package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsViewState
import kotlinx.coroutines.flow.StateFlow

abstract class HostsViewModel : ViewModel() {
    abstract val searchQuery: StateFlow<String>

    abstract val filters: StateFlow<Map<HostsFilterType, HostsFilter>>
    abstract val ordersList: List<HostsOrder>
    abstract val selectedOrder: StateFlow<HostsOrder>
    abstract val viewState: StateFlow<HostsViewState>

    abstract fun load()

    abstract fun changeQuery(query: String)
    abstract fun updateFilter(filterType: HostsFilterType, filter: HostsFilter)

    abstract fun updateOrder(order: HostsOrder)
}