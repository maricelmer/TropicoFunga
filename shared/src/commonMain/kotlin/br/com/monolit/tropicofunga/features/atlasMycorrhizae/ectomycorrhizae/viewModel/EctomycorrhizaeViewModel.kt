package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeViewState
import kotlinx.coroutines.flow.StateFlow

abstract class EctomycorrhizaeViewModel : ViewModel() {
    abstract val searchQuery: StateFlow<String>

    abstract val filters: StateFlow<Map<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>>
    abstract val ordersList: List<EctomycorrhizaeOrder>
    abstract val selectedOrder: StateFlow<EctomycorrhizaeOrder>
    abstract val viewState: StateFlow<EctomycorrhizaeViewState>

    abstract fun load()

    abstract fun changeQuery(query: String)
    abstract fun updateFilter(filterType: EctomycorrhizaeFilterType, filter: EctomycorrhizaeFilter)

    abstract fun updateOrder(order: EctomycorrhizaeOrder)
}