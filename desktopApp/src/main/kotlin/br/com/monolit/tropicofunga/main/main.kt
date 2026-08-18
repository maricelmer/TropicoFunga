package br.com.monolit.tropicofunga.main

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.monolit.tropicofunga.App
import br.com.monolit.tropicofunga.koin.initializeKoin
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
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
    ) {
        App()
    }
}