package br.ufsc.micolab.tropicoecm.features.ectomycorrhizae.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.ufsc.micolab.tropicoecm.features.ectomycorrhizae.view.EctomycorrhizaeView

@Composable
fun EctomycorrhizaeScreen(
    onBackPressed: () -> Unit,
) {

    EctomycorrhizaeView(
        modifier = Modifier.fillMaxSize(),
        onBackPressed = onBackPressed,
    )
}