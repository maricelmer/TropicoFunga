package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.viewModel.FungiViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.view.GlossaryView
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.viewModel.GlossaryViewModel
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GlossaryScreen(
    onBackPressed: () -> Unit,
    viewModel: GlossaryViewModel = koinViewModel(),
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedOrder by viewModel.selectedOrder.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    GlossaryView(
        modifier = Modifier.fillMaxSize(),
        searchQuery = searchQuery,
        selectedOrder = selectedOrder,
        ordersList = viewModel.ordersList,
        viewState = viewState,
        onQueryChanged = viewModel::changeQuery,
        onBackPressed = onBackPressed,
        updateOrderRequested = viewModel::updateOrder,
        onTryLoadAgainRequest = viewModel::load
    )
}