package br.com.monolit.tropicofunga.features.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.home.view.HomeView

@Composable
fun HomeScreen(
    openFunga: () -> Unit,
    openAtlasMycorrhizae: () -> Unit,
    openSettings: () -> Unit,
) {
    HomeView(
        modifier = Modifier.fillMaxSize(),
        openFunga = openFunga,
        openAtlasMycorrhizae = openAtlasMycorrhizae,
        openSettings = openSettings,
    )
}