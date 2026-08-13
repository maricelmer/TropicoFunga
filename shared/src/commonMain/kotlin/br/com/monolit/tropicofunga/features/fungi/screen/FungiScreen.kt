package br.com.monolit.tropicofunga.features.fungi.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.fungi.view.FungiView

@Composable
fun FungiScreen(
    onBackPressed: () -> Unit,
) {
    FungiView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}