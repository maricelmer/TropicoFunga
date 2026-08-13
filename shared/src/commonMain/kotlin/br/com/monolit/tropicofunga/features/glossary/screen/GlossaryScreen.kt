package br.com.monolit.tropicofunga.features.glossary.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.glossary.view.GlossaryView

@Composable
fun GlossaryScreen(
    onBackPressed: () -> Unit,
) {
    GlossaryView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}