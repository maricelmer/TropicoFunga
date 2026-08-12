package br.ufsc.micolab.tropicoecm.features.glossary.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.ufsc.micolab.tropicoecm.features.glossary.view.GlossaryView

@Composable
fun GlossaryScreen(
    onBackPressed: () -> Unit,
) {
    GlossaryView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}