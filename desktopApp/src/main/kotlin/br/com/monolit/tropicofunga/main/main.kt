package br.com.monolit.tropicofunga.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.monolit.tropicofunga.App
import br.com.monolit.tropicofunga.koin.initializeKoin
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import org.jetbrains.compose.resources.decodeToImageBitmap
import org.koin.dsl.module
import java.util.prefs.Preferences

fun main() = application {

    initializeKoin(
        specializedModule = module {
            single<Settings> {
                PreferencesSettings(
                    Preferences.userRoot().node("br/com/monolit/tropicofunga")
                )
            }
        }
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tropico Funga",
        icon = rememberClasspathIcon("icons/icon.png"),
    ) {
        App()
    }
}

/**
 * Loads a PNG straight from the runtime classpath (desktopApp/src/main/resources)
 * as a window icon. `androidx.compose.ui.res.painterResource(resourcePath: String)`
 * is deprecated in favor of the Compose Resources library, but that library's
 * codegen (Res.drawable.*) targets shared/composeResources, not this module's
 * plain classpath resources - so we decode the bytes ourselves, per the pattern
 * JetBrains documents for this exact case:
 * https://github.com/JetBrains/compose-multiplatform-core/pull/1457
 */
@Composable
private fun rememberClasspathIcon(resourcePath: String): Painter {
    return remember(resourcePath) {
        val bytes = requireNotNull(
            object {}.javaClass.classLoader.getResourceAsStream(resourcePath)
        ) { "Classpath resource not found: $resourcePath" }.use { it.readBytes() }
        BitmapPainter(bytes.decodeToImageBitmap())
    }
}
