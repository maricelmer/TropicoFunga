package br.com.monolit.tropicofunga.features.atlasMycorrhizae.about.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.shared.views.DefaultAppBar
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.StillBeingBuiltView
import com.example.compose.AppTheme

@Composable
fun AboutView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = "About",
                onBackPressed = onBackPressed,
            )
        },
    ) {
        StillBeingBuiltView()
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AppTheme {
        AboutView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
        )
    }
}