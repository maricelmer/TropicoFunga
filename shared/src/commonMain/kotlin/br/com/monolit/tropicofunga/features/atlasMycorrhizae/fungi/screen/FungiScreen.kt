package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.view.FungiView
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.viewModel.FungiViewModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun FungiScreen(
    onBackPressed: () -> Unit,
    viewModel: FungiViewModel = koinViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val filters by viewModel.filters.collectAsState()
    val selectedOrder by viewModel.selectedOrder.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    FungiView(
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
        onTryLoadAgainRequest = viewModel::load
    )
}