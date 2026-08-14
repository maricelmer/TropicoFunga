package br.com.monolit.tropicofunga

import androidx.compose.ui.window.ComposeUIViewController
import br.com.monolit.tropicofunga.koin.initializeKoin
import org.koin.dsl.module
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {

    initializeKoin(
        specializedModule = module {

        }
    )

    return ComposeUIViewController { App() }
}