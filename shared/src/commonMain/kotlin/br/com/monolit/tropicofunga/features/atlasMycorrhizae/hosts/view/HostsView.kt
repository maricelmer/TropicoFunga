package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.monolit.tropicofunga.features.shared.views.DefaultAppBar
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.StillBeingBuiltView
import com.example.compose.AppTheme

@Composable
fun HostsView(
    modifier: Modifier,
    onBackPressed: () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = "Hosts",
                onBackPressed = onBackPressed,
            )
        },
    ) {
        StillBeingBuiltView()
    }
}

@Preview(showBackground = true)
@Composable
private fun HostsPreview() {
    AppTheme {
        HostsView(
            modifier = Modifier.fillMaxSize(),
            onBackPressed = {},
        )
    }
}