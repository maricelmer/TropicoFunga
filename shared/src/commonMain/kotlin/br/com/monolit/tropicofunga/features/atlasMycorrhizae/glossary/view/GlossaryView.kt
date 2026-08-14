package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.shared.views.DefaultAppBar
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.StillBeingBuiltView
import com.example.compose.AppTheme

@Composable
fun GlossaryView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = "Glossary",
                onBackPressed = onBackPressed,
            )
        },
    ) {
        StillBeingBuiltView()
    }
}

@Preview(showBackground = true)
@Composable
private fun GlossaryPreview() {
    AppTheme {
        GlossaryView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
        )
    }
}