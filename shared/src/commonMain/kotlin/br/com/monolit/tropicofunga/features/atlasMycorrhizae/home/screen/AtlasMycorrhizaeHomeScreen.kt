package br.com.monolit.tropicofunga.features.atlasMycorrhizae.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.home.view.AtlasMycorrhizaeHomeView
import br.com.monolit.tropicofunga.features.home.view.HomeView

@Composable
fun AtlasMycorrhizaeHomeScreen(
    openEctomycorrhizae: () -> Unit,
    openHowToCollect: () -> Unit,
    openGlossary: () -> Unit,
    openFungi: () -> Unit,
    openHosts: () -> Unit,
    openAbout: () -> Unit,
    onBackPressed: () -> Unit,
) {
    AtlasMycorrhizaeHomeView(
        modifier = Modifier.fillMaxSize(),
        openEctomycorrhizae = openEctomycorrhizae,
        openHowToCollect = openHowToCollect,
        openGlossary = openGlossary,
        openFungi = openFungi,
        openHosts = openHosts,
        openAbout = openAbout,
        onBackPressed = onBackPressed,
    )
}