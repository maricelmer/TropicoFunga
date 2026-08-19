package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.data.DataImage
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.view.HostsView
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.viewModel.HostsViewModel
import br.com.monolit.tropicofunga.features.shared.views.ImageCarouselView
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HostsScreen(
    onBackPressed: () -> Unit,
    viewModel: HostsViewModel = koinViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val filters by viewModel.filters.collectAsState()
    val selectedOrder by viewModel.selectedOrder.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var viewImage by remember { mutableStateOf<DataImage?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        HostsView(
            modifier = Modifier.fillMaxSize(),
            searchQuery = searchQuery,
            filters = filters,
            selectedOrder = selectedOrder,
            ordersList = viewModel.ordersList,
            viewState = viewState,
            drawerState = drawerState,
            onQueryChanged = viewModel::changeQuery,
            onBackPressed = onBackPressed,
            onFilterPressed = {
                scope.launch {
                    if (drawerState.isOpen) {
                        drawerState.close()
                    } else {
                        drawerState.open()
                    }
                }
            },
            updateFilterRequested = viewModel::updateFilter,
            updateOrderRequested = viewModel::updateOrder,
            onTryLoadAgainRequest = viewModel::load,
            openImageRequest = { viewImage = it }
        )
        AnimatedContent(viewImage) { image ->
            if (image != null) {
                ImageCarouselView(
                    modifier = Modifier.fillMaxSize(),
                    openInImageIndex = 0,
                    imagesPaths = listOf(image),
                    onCloseRequest = { viewImage = null }
                )
            }
        }
    }
}