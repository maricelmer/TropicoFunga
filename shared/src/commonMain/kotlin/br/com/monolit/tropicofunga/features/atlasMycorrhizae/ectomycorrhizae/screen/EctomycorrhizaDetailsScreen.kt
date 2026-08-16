package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.viewstate.EctomycorrhizaDetailsViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view.EctomycorrhizaDetailsView
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaDetailsViewModel
import br.com.monolit.tropicofunga.features.shared.ImageCarouselView
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import kotlin.uuid.Uuid

@Composable
fun EctomycorrhizaDetailsScreen(
    id: Uuid,
    onBackPressed: () -> Unit,
    viewModel: EctomycorrhizaDetailsViewModel = koinViewModel { parametersOf(id) }
) {
    val viewState by viewModel.viewState.collectAsState()

    var viewImageIndex by rememberSaveable { mutableStateOf<Int?>(null) }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        EctomycorrhizaDetailsView(
            modifier = Modifier.fillMaxSize(),
            viewState = viewState,
            onBackPressed = onBackPressed,
            onTryLoadAgainRequest = viewModel::load,
            onViewImagesRequest = { viewImageIndex = it }
        )
        AnimatedContent(viewImageIndex) { index ->
            val imagesPaths =
                (viewState as? EctomycorrhizaDetailsViewState.Loaded)?.ectomycorrhiza?.photos
                    ?: emptyList()
            if (imagesPaths.isNotEmpty() && index != null) {
                ImageCarouselView(
                    modifier = Modifier.fillMaxSize(),
                    openInImageIndex = index,
                    imagesPaths = imagesPaths,
                    onCloseRequest = { viewImageIndex = null }
                )
            }
        }
    }
}