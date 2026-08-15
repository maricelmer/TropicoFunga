package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.view.EctomycorrhizaeView
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaeViewModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import kotlin.uuid.Uuid

@Composable
fun EctomycorrhizaeScreen(
    onBackPressed: () -> Unit,
    openEctomycorrhizaDetails: (Uuid) -> Unit,
    viewModel: EctomycorrhizaeViewModel = koinViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val filters by viewModel.filters.collectAsState()
    val selectedOrder by viewModel.selectedOrder.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    EctomycorrhizaeView(
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
        openEctomycorrhizaDetails = openEctomycorrhizaDetails,
        onTryLoadAgainRequest = viewModel::load
    )
}