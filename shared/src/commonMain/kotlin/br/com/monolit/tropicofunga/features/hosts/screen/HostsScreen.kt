package br.com.monolit.tropicofunga.features.hosts.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.hosts.view.HostsView

@Composable
fun HostsScreen(
    onBackPressed: () -> Unit,
) {
    HostsView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}