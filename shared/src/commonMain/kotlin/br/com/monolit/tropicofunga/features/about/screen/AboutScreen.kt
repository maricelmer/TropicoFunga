package br.com.monolit.tropicofunga.features.about.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.about.view.AboutView

@Composable
fun AboutScreen(
    onBackPressed: () -> Unit,
) {
    AboutView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}