package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryViewState
import kotlinx.coroutines.flow.StateFlow

abstract class GlossaryViewModel : ViewModel() {
    abstract val searchQuery: StateFlow<String>

    abstract val ordersList: List<GlossaryOrder>
    abstract val selectedOrder: StateFlow<GlossaryOrder>
    abstract val viewState: StateFlow<GlossaryViewState>

    abstract fun load()

    abstract fun changeQuery(query: String)

    abstract fun updateOrder(order: GlossaryOrder)
}