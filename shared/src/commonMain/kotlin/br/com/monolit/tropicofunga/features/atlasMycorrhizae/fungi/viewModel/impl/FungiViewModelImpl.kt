package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.data.fungus.Fungus
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data.FungiViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.viewModel.FungiViewModel
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.repository.AppRepository
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FungiViewModelImpl(
    private val repository: AppRepository,
) : FungiViewModel() {

    override val searchQuery = MutableStateFlow("")

    override val filters =
        MutableStateFlow<PersistentMap<FungiFilterType, FungiFilter>>(
            persistentMapOf()
        )

    override val ordersList = FungiOrder.entries
    override val selectedOrder = MutableStateFlow(FungiOrder.NAME_ASC)

    private val _viewState = MutableStateFlow<FungiViewState>(FungiViewState.Loading)
    override val viewState = combine(
        _viewState,
        selectedOrder,
    ) { state, order ->
        when (state) {
            FungiViewState.Loading -> state
            is FungiViewState.Error -> state
            is FungiViewState.Loaded -> {
                FungiViewState.Loaded(
                    fungi = state.fungi.order(order)
                )
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, FungiViewState.Loading)

    init {
        load()
    }

    var loadJob: Job? = null
    override fun load() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            repository.loadFungi()
                .onSuccess { fungi ->
                    val specie = mutableSetOf<FungiFilter.Option>()
                    val families = mutableSetOf<FungiFilter.Option>()

                    fungi.forEach { fungus ->
                        fungus.specie?.let {
                            specie.add(
                                FungiFilter.Option(
                                    id = it.id,
                                    name = it.name
                                )
                            )
                        }
                        families.add(
                            FungiFilter.Option(
                                id = fungus.family.id,
                                name = fungus.family.name.toAnnotatedString()
                            )
                        )
                    }

                    filters.update {
                        val specieFilter = it[FungiFilterType.SPECIE].update(options = specie)
                        val familyFilter = it[FungiFilterType.FAMILY].update(options = families)

                        it.putting(FungiFilterType.SPECIE, specieFilter)
                            .putting(FungiFilterType.FAMILY, familyFilter)
                    }

                    combine(
                        searchQuery,
                        filters,
                    ) { query, filtersList ->
                        query to filtersList
                    }.collect { (query, filtersList) ->
                        _viewState.update { FungiViewState.Loading }
                        _viewState.update {
                            FungiViewState.Loaded(
                                fungi = fungi.filter(query, filtersList)
                            )
                        }
                    }
                }
                .onFailure { exception ->
                    // TODO internationalize error message
                    _viewState.update { FungiViewState.Error("Failed to load fungi") }
                    println("Error occurred while loading fungi: ${exception.message}")
                }
        }
    }

    override fun changeQuery(query: String) {
        searchQuery.update { query }
    }

    override fun updateFilter(
        filterType: FungiFilterType,
        filter: FungiFilter
    ) {
        filters.update { it.putting(filterType, filter) }
    }

    override fun updateOrder(order: FungiOrder) {
        selectedOrder.update { order }
    }
}

internal fun List<Fungus>.order(order: FungiOrder): List<Fungus> {
    return when (order) {
        FungiOrder.NAME_ASC -> this.sortedBy { it.name.text }
        FungiOrder.NAME_DESC -> this.sortedByDescending { it.name.text }
        FungiOrder.SPECIE_ASC -> this.sortedBy { it.specie?.name?.text }
        FungiOrder.SPECIE_DESC -> this.sortedByDescending { it.specie?.name?.text }
        FungiOrder.FAMILY_ASC -> this.sortedBy { it.family.name }
        FungiOrder.FAMILY_DESC -> this.sortedByDescending { it.family.name }
    }
}

internal fun List<Fungus>.filter(
    query: String,
    filters: Map<FungiFilterType, FungiFilter>
): List<Fungus> {
    // Apply selected filters first for better performance
    val specieFilter = filters[FungiFilterType.SPECIE] as? FungiFilter.MultipleSelection
    val familyFilter = filters[FungiFilterType.FAMILY] as? FungiFilter.MultipleSelection

    val filteredByFilters = this.filter { item ->
        val specieOk = specieFilter?.selected?.let { it.isEmpty() || item.specie?.id in it } ?: true
        val familyOk = familyFilter?.selected?.let { it.isEmpty() || item.family.id in it } ?: true
        specieOk && familyOk
    }

    if (query.isBlank()) return filteredByFilters

    val q = query.lowercase()
    return filteredByFilters.filter { item ->
        item.name.text.lowercase().contains(q)
    }
}

internal fun FungiFilter?.update(options: Set<FungiFilter.Option>): FungiFilter {
    val ids = options.map { it.id }
    return when (this) {
        is FungiFilter.MultipleSelection -> {
            this.copy(
                options = options,
                selected = this.selected.filter { it in ids }.toSet(),
                expanded = this.expanded
            )
        }

        null -> {
            FungiFilter.MultipleSelection(
                options = options,
                selected = emptySet(),
                expanded = false,
            )
        }
    }
}