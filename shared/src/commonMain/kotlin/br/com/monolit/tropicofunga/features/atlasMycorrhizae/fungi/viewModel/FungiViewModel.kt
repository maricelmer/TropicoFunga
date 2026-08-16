package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiViewState
import kotlinx.coroutines.flow.StateFlow

abstract class FungiViewModel : ViewModel() {
    abstract val searchQuery: StateFlow<String>

    abstract val filters: StateFlow<Map<FungiFilterType, FungiFilter>>
    abstract val ordersList: List<FungiOrder>
    abstract val selectedOrder: StateFlow<FungiOrder>
    abstract val viewState: StateFlow<FungiViewState>

    abstract fun load()

    abstract fun changeQuery(query: String)
    abstract fun updateFilter(filterType: FungiFilterType, filter: FungiFilter)

    abstract fun updateOrder(order: FungiOrder)
}