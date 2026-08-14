package br.com.monolit.tropicofunga.main

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import br.com.monolit.tropicofunga.App
import br.com.monolit.tropicofunga.koin.initializeKoin
import org.koin.dsl.module

fun main() = application {

    initializeKoin(
        specializedModule = module {

        }
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tropico Funga",
    ) {
        App()
    }
}