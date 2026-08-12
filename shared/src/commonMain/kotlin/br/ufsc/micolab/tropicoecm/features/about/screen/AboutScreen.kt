package br.ufsc.micolab.tropicoecm.features.about.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.ufsc.micolab.tropicoecm.features.about.view.AboutView

@Composable
fun AboutScreen(
    onBackPressed: () -> Unit,
) {
    AboutView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}