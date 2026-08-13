package br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.view.HowToCollectView

@Composable
fun HowToCollectScreen(
    onBackPressed: () -> Unit,
) {
    HowToCollectView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}