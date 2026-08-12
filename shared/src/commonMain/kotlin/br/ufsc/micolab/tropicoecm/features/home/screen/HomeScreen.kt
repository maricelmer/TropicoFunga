package br.ufsc.micolab.tropicoecm.features.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.ufsc.micolab.tropicoecm.features.home.view.HomeView

@Composable
fun HomeScreen(
    openEctomycorrhizae: () -> Unit,
    openHowToCollect: () -> Unit,
    openGlossary: () -> Unit,
    openFungi: () -> Unit,
    openHosts: () -> Unit,
    openAbout: () -> Unit,
) {
    HomeView(
        modifier = Modifier.fillMaxSize(),
        openEctomycorrhizae = openEctomycorrhizae,
        openHowToCollect = openHowToCollect,
        openGlossary = openGlossary,
        openFungi = openFungi,
        openHosts = openHosts,
        openAbout = openAbout,
    )
}