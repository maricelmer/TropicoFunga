# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

Tropico Funga is a Kotlin Multiplatform + Compose Multiplatform app targeting Android, iOS, and Desktop (JVM). It is an **offline field-guide catalog** (mycorrhizal fungi, host plants, glossary) with no backend, no network calls, and no analytics/ads SDKs — all content ships in the app as static Kotlin data.

- `androidApp` — Android application shell (entry point, manifest, signing/build config).
- `desktopApp` — Desktop (JVM) application shell (`main()`).
- `iosApp` — Xcode project; SwiftUI entry point that hosts the shared Compose UI.
- `shared` — all real logic and UI: `commonMain` (business logic + Compose UI, ~everything), with thin `androidMain`/`iosMain`/`jvmMain` source sets only for `expect`/`actual` platform hooks.

## Common commands

Run all Gradle commands from the repo root.

```bash
# Android debug build
./gradlew :androidApp:assembleDebug

# Android release bundle (signed AAB for Play Store — requires local.properties
# RELEASE_STORE_FILE/RELEASE_STORE_PASSWORD/RELEASE_KEY_ALIAS/RELEASE_KEY_PASSWORD,
# or the equivalent env vars; falls back to an unsigned build with a warning if absent)
./gradlew :androidApp:bundleRelease

# Desktop app
./gradlew :desktopApp:run
./gradlew :desktopApp:hotRun --auto   # hot reload

# iOS: open iosApp/iosApp.xcodeproj in Xcode and run from there
```

Tests (no single-test CLI flag configured — use `--tests "ClassName.methodName"` with any of these, e.g. `./gradlew :shared:jvmTest --tests "SharedLogicDesktopTest.example"`):

```bash
./gradlew :shared:testAndroidHostTest      # Android unit tests (JVM, Robolectric-less host test)
./gradlew :shared:jvmTest                  # Desktop/JVM tests
./gradlew :shared:iosSimulatorArm64Test    # iOS simulator tests
```

There is no linter/formatter (no ktlint/detekt/spotless) configured in this repo.

## Versioning

`versionCode`/`versionName` for the Android app are **not** set directly in `androidApp/build.gradle.kts` — they're derived from a single `app.version` key in the root [gradle.properties](gradle.properties), formatted `year.major.minor` (e.g. `26.1.0`). The derivation logic (with validation) lives at the top of [androidApp/build.gradle.kts](androidApp/build.gradle.kts):

- `versionName` = `app.version` as-is.
- `versionCode` = `year * 10_000 + major * 100 + minor` (so `major`/`minor` must stay `0..99`, and the value is guaranteed to increase for any later version).

To cut a new release, bump `app.version` in `gradle.properties` — do not hand-edit `versionCode`/`versionName`.

## Architecture

### Feature module shape

Every screen under `shared/src/commonMain/kotlin/.../features/**` follows the same layered convention — when adding a new screen, mirror this structure rather than inventing a new one:

```
features/<area>/<feature>/
  data/           view state, filter/order enums, etc. (plain data classes)
  screen/         @Composable "Screen" — wires a koinViewModel() to a View, owns navigation callbacks
  view/           @Composable "View" — stateless UI, takes state + lambdas as parameters
  viewModel/      abstract ViewModel class declaring StateFlow<...> properties + actions
  viewModel/impl/ concrete ViewModelImpl(repository: AppRepository) : ViewModel(), does the real work
```

`Screen` composables are the only place that call `koinViewModel()`; `View` composables are pure functions of state, which keeps them previewable/testable. ViewModels are declared as `abstract class` (not interface) in `viewModel/`, registered against their abstract type in [features/FeaturesModule.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/features/FeaturesModule.kt) via Koin's `viewModel<AbstractType> { ImplType(...) }`.

### Data layer

All content (fungi, hosts, ectomycorrhizae, glossary) is hardcoded in [repository/impl/staticData/StaticData.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/repository/impl/staticData/StaticData.kt) (~1300 lines) and served through [repository/impl/StaticDataAppRepositoryImpl.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/repository/impl/StaticDataAppRepositoryImpl.kt), which implements [repository/AppRepository.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/repository/AppRepository.kt) (`suspend fun load...(): Result<...>`). There is no database and no HTTP client — to add/edit catalog content, edit `StaticData.kt` directly. Images referenced by that data live in `shared/src/commonMain/composeResources` and are loaded with Coil3 (`libs.coil`) + `zoomimage-compose-coil3` for pinch-to-zoom viewers ([features/shared/views/ImageCarouselView](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/features/shared/views)).

### Navigation

Type-safe Navigation Compose: routes are `@Serializable` sealed types in [navigation/routes/AppRoutes.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/navigation/routes/AppRoutes.kt) (nested `sealed interface` per section, e.g. `AppRoutes.AtlasMycorrhizae.Fungi`), wired up in [navigation/main/AppNavHost.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/navigation/main/AppNavHost.kt) with `composable<AppRoutes.X> { ... }`. Non-primitive route args (e.g. `kotlin.uuid.Uuid`) need a custom `NavType` registered via `typeMap` — see [navigation/utils/UuidNavType.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/navigation/utils/UuidNavType.kt).

### Cross-platform settings (theme/language)

`ThemeRepository` and `LanguageRepository` ([theme/](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/theme) / [language/](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/language)) persist via `com.russhwolf.settings.Settings` (multiplatform-settings), but the concrete `Settings` implementation is provided per-platform at the app entry point, not in `shared`:

- Android: `SharedPreferencesSettings` in [androidApp BaseApplication](androidApp/src/main/kotlin/br/com/monolit/tropicofunga/application/BaseApplication.kt).
- Desktop: `PreferencesSettings` (`java.util.prefs`) in [desktopApp main.kt](desktopApp/src/main/kotlin/br/com/monolit/tropicofunga/main/main.kt).
- iOS: `NSUserDefaultsSettings` in [shared iosMain MainViewController.kt](shared/src/iosMain/kotlin/br/com/monolit/tropicofunga/main/MainViewController.kt).

Each of these calls `initializeKoin(specializedModule = module { single<Settings> { ... } }, applyContext = ...)` ([koin/KoinModule.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/koin/KoinModule.kt)), which then loads the shared `repositoryModule` / `featuresModule` / `languageModule` / `themeModule` plus that platform-specific module. Any new platform-scoped dependency (e.g. a platform API) should follow this same "inject as `specializedModule` from the platform entry point" pattern rather than reaching for `expect`/`actual` unless the code itself (not just its wiring) differs per platform.

Locale switching is handled by an `expect`/`actual` [AppLocale.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/language/AppLocale.kt) (Android/iOS/JVM implementations). In [App.kt](shared/src/commonMain/kotlin/br/com/monolit/tropicofunga/App.kt), the whole `AppNavHost` is wrapped in `key(currentLanguage)` so changing the language rebuilds every `stringResource()` call in the tree immediately, even on platforms without automatic activity recreation (Desktop/iOS).

### Android release build

Signing, `versionCode`/`versionName` derivation, and R8/minify are all in [androidApp/build.gradle.kts](androidApp/build.gradle.kts):

- Signing credentials come from `local.properties` (`RELEASE_STORE_FILE`, `RELEASE_STORE_PASSWORD`, `RELEASE_KEY_ALIAS`, `RELEASE_KEY_PASSWORD`), falling back to matching env vars for CI. Never hardcode these in the build script.
- `release` build type has `isMinifyEnabled = true` + `isShrinkResources = true`; [proguard-rules.pro](androidApp/proguard-rules.pro) has extra `kotlinx.serialization` keep rules for the `@Serializable` nav routes.
- Backup behavior is explicit via [res/xml/data_extraction_rules.xml](androidApp/src/main/res/xml/data_extraction_rules.xml) (API 31+) and [res/xml/full_backup_content.xml](androidApp/src/main/res/xml/full_backup_content.xml) (API 24–30) — both currently include everything, since there's no sensitive local data.
