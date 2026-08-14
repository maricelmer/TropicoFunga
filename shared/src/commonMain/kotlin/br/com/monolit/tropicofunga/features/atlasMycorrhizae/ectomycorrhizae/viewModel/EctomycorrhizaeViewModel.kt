package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilterType
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EctomycorrhizaeViewModel : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _filters =
        MutableStateFlow<PersistentMap<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>>(
            persistentMapOf()
        )
    val filters: StateFlow<Map<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>> =
        _filters.asStateFlow()

    init {
        _filters.update {
            persistentMapOf(
                EctomycorrhizaeFilterType.HOST to EctomycorrhizaeFilter.MultipleSelection(
                    options = listOf("Host 1", "Host 2", "Host 3"),
                    selected = emptySet(),
                    expanded = false,
                ),
                EctomycorrhizaeFilterType.FUNGUS to EctomycorrhizaeFilter.MultipleSelection(
                    options = listOf("Fungus 1", "Fungus 2", "Fungus 3"),
                    selected = emptySet(),
                    expanded = false,
                )
            )
        }
    }

    fun changeQuery(query: String) {
        _searchQuery.update { query }
    }

    fun updateFilter(filterType: EctomycorrhizaeFilterType, filter: EctomycorrhizaeFilter) {
        _filters.update { it.putting(filterType, filter) }
    }
}