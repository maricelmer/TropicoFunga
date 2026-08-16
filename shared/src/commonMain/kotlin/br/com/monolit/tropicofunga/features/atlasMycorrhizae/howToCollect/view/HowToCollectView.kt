package br.com.monolit.tropicofunga.features.atlasMycorrhizae.howToCollect.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.StillBeingBuiltView
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar
import com.example.compose.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowToCollectView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = "How to collect",
                onBackPressed = onBackPressed,
            )
        },
    ) {
        StillBeingBuiltView()
    }
}

@Preview(showBackground = true)
@Composable
private fun HowToCollectPreview() {
    AppTheme {
        HowToCollectView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
        )
    }
}