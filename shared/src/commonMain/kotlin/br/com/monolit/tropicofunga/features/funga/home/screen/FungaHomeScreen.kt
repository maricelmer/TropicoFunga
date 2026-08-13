package br.com.monolit.tropicofunga.features.funga.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.funga.home.view.FungaHomeView

@Composable
fun FungaHomeScreen(
    onBackPressed: () -> Unit,
) {
    FungaHomeView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}