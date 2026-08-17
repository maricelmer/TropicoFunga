package br.com.monolit.tropicofunga.features.atlasMycorrhizae.about.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.about.view.AboutView

@Composable
fun AboutScreen(
    onBackPressed: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    AboutView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
        onOpenContributeFormRequested = {
            uriHandler.openUri("https://docs.google.com/forms/d/e/1FAIpQLSdEt4DnqK5WK3PSVwfE_uhWmCyBVvhzDYXPIpGap3HkCFFyDw/viewform?usp=header\n")
        }
    )
}