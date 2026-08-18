package br.com.monolit.tropicofunga

import androidx.compose.ui.window.ComposeUIViewController
import br.com.monolit.tropicofunga.koin.initializeKoin
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {

    initializeKoin(
        specializedModule = module {
            single<Settings> {
                NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
            }
        }
    )

    return ComposeUIViewController { App() }
}