package br.ufsc.micolab.tropicoecm.features.howToCollect.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.ufsc.micolab.tropicoecm.features.howToCollect.view.HowToCollectView

@Composable
fun HowToCollectScreen(
    onBackPressed: () -> Unit,
) {
    HowToCollectView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}