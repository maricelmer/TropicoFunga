import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}
dependencies {
    implementation(project(":shared"))

    implementation(libs.androidx.activity.compose)

    implementation(libs.compose.uiToolingPreview)
    debugImplementation(libs.compose.uiTooling)

    // koin - Inject dependency
    implementation(libs.koin.android)

    implementation(libs.multiplatform.settings)
}

// Signing credentials: read from local.properties first (local/dev machine),
// falling back to environment variables (CI). Never hardcode secrets here.
val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}

fun releaseProp(key: String): String? =
    (localProperties.getProperty(key) ?: System.getenv(key))?.takeIf { it.isNotBlank() }

val releaseStoreFile = releaseProp("RELEASE_STORE_FILE")
val releaseStorePassword = releaseProp("RELEASE_STORE_PASSWORD")
val releaseKeyAlias = releaseProp("RELEASE_KEY_ALIAS")
val releaseKeyPassword = releaseProp("RELEASE_KEY_PASSWORD")
val hasReleaseSigningConfig = listOf(
    releaseStoreFile,
    releaseStorePassword,
    releaseKeyAlias,
    releaseKeyPassword
).all { it != null }

// Versao do app: definida em uma unica fonte de verdade (gradle.properties -> app.version),
// no formato ano.major.minor, ex: 26.1.0.
val appVersion = (project.findProperty("app.version") as String?)
    ?: error("Defina app.version em gradle.properties, ex: app.version=26.1.0")

val (appVersionYear, appVersionMajor, appVersionMinor) = appVersion.split(".")
    .also {
        require(it.size == 3) {
            "app.version deve seguir o formato ano.major.minor (ex: 26.1.0). Valor atual: $appVersion"
        }
    }
    .map { part ->
        part.trim().toIntOrNull()
            ?: error("app.version deve conter apenas numeros separados por ponto (ex: 26.1.0). Valor atual: $appVersion")
    }

require(appVersionMajor in 0..99 && appVersionMinor in 0..99) {
    "major e minor de app.version devem estar entre 0 e 99, para o versionCode derivado " +
        "nao colidir entre versoes (app.version=$appVersion)"
}

// versionCode monotonico: AAAA_MM_mm, ex 26.1.0 -> 260100. Garante que cada novo
// app.version gere um versionCode maior que o anterior, exigencia da Play Store.
val appVersionCode = appVersionYear * 10_000 + appVersionMajor * 100 + appVersionMinor

android {
    namespace = "br.com.monolit.tropicofunga"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "br.com.monolit.tropicofunga"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        // Origem unica: app.version em gradle.properties (formato ano.major.minor).
        versionCode = appVersionCode
        versionName = appVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    signingConfigs {
        if (hasReleaseSigningConfig) {
            create("release") {
                storeFile = rootProject.file(releaseStoreFile!!)
                storePassword = releaseStorePassword
                keyAlias = releaseKeyAlias
                keyPassword = releaseKeyPassword
            }
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            ndk.debugSymbolLevel = "FULL"
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            if (hasReleaseSigningConfig) {
                signingConfig = signingConfigs.getByName("release")
            } else {
                logger.warn(
                    "RELEASE_STORE_FILE/RELEASE_STORE_PASSWORD/RELEASE_KEY_ALIAS/RELEASE_KEY_PASSWORD " +
                        "not found in local.properties or environment. Release build will be unsigned."
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}
