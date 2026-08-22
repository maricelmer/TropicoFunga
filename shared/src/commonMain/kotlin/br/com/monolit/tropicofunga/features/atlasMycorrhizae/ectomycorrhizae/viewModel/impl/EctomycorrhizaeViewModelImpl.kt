package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.data.ectomycorrhiza.EctomycorrhizaItem
import br.com.monolit.tropicofunga.data.ectomycorrhiza.toItems
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaeViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaeViewModel
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.log.AppLogger
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
import org.jetbrains.compose.resources.getString
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.failed_to_load_ectomycorrhizae_error

class EctomycorrhizaeViewModelImpl(
    private val repository: AppRepository,
) : EctomycorrhizaeViewModel() {

    override val searchQuery = MutableStateFlow("")

    override val filters =
        MutableStateFlow<PersistentMap<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>>(
            persistentMapOf()
        )


    override val ordersList = EctomycorrhizaeOrder.entries
    override val selectedOrder = MutableStateFlow(EctomycorrhizaeOrder.FUNGUS_ASC)

    private val _viewState =
        MutableStateFlow<EctomycorrhizaeViewState>(
            EctomycorrhizaeViewState.Loading
        )
    override val viewState = combine(
        _viewState,
        selectedOrder,
    ) { state, order ->
        when (state) {
            EctomycorrhizaeViewState.Loading -> state
            is EctomycorrhizaeViewState.Error -> state
            is EctomycorrhizaeViewState.Loaded -> {
                EctomycorrhizaeViewState.Loaded(
                    ectomycorrhizae = state.ectomycorrhizae.order(order)
                )
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, EctomycorrhizaeViewState.Loading)

    init {
        load()
    }

    var loadJob: Job? = null
    override fun load() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            repository.loadEctomycorrhizae()
                .onSuccess { ectomycorrhizae ->
                    val types = mutableSetOf<EctomycorrhizaeFilter.Option>()
                    val hosts = mutableSetOf<EctomycorrhizaeFilter.Option>()
                    val fungi = mutableSetOf<EctomycorrhizaeFilter.Option>()

                    ectomycorrhizae.forEach { ectomycorrhiza ->
                        types.add(
                            EctomycorrhizaeFilter.Option(
                                id = ectomycorrhiza.type.id,
                                name = ectomycorrhiza.type.name.toAnnotatedString()
                            )
                        )
                        hosts.add(
                            EctomycorrhizaeFilter.Option(
                                id = ectomycorrhiza.host.id,
                                name = ectomycorrhiza.host.name
                            )
                        )
                        fungi.add(
                            EctomycorrhizaeFilter.Option(
                                id = ectomycorrhiza.fungus.id,
                                name = ectomycorrhiza.fungus.name
                            )
                        )
                    }

                    filters.update {
                        val typeFilter =
                            it[EctomycorrhizaeFilterType.TYPE].update(options = types)
                        val hostFilter =
                            it[EctomycorrhizaeFilterType.HOST].update(options = hosts)
                        val fungusFilter =
                            it[EctomycorrhizaeFilterType.FUNGUS].update(options = fungi)

                        it.putting(EctomycorrhizaeFilterType.TYPE, typeFilter)
                            .putting(EctomycorrhizaeFilterType.HOST, hostFilter)
                            .putting(EctomycorrhizaeFilterType.FUNGUS, fungusFilter)
                    }

                    combine(
                        searchQuery,
                        filters,
                    ) { query, filtersList ->
                        query to filtersList
                    }.collect { (query, filtersList) ->
                        _viewState.update { EctomycorrhizaeViewState.Loading }
                        _viewState.update {
                            EctomycorrhizaeViewState.Loaded(
                                ectomycorrhizae = ectomycorrhizae
                                    .filter(query, filtersList)
                                    .toItems()
                            )
                        }
                    }
                }
                .onFailure { exception ->
                    _viewState.update {
                        EctomycorrhizaeViewState.Error(getString(Res.string.failed_to_load_ectomycorrhizae_error))
                    }
                    AppLogger.e("EctomycorrhizaeViewModel", "Error occurred while loading ectomycorrhizae", exception)
                }
        }
    }

    override fun changeQuery(query: String) {
        searchQuery.update { query }
    }

    override fun updateFilter(
        filterType: EctomycorrhizaeFilterType,
        filter: EctomycorrhizaeFilter
    ) {
        filters.update { it.putting(filterType, filter) }
    }

    override fun updateOrder(order: EctomycorrhizaeOrder) {
        selectedOrder.update { order }
    }
}

internal suspend fun List<EctomycorrhizaItem>.order(order: EctomycorrhizaeOrder): List<EctomycorrhizaItem> {
    return when (order) {
        EctomycorrhizaeOrder.FUNGUS_ASC -> this.sortedBy { it.fungus.text }
        EctomycorrhizaeOrder.FUNGUS_DESC -> this.sortedByDescending { it.fungus.text }
        EctomycorrhizaeOrder.HOST_ASC -> this.sortedBy { it.host.text }
        EctomycorrhizaeOrder.HOST_DESC -> this.sortedByDescending { it.host.text }
        EctomycorrhizaeOrder.TYPE_ASC -> this.sortedBy { it.type.name }
        EctomycorrhizaeOrder.TYPE_DESC -> this.sortedByDescending { it.type.name }
        EctomycorrhizaeOrder.ECOSYSTEM_ASC ->
            this.map { it to getString(it.ecosystem) }.sortedBy { it.second }.map { it.first }

        EctomycorrhizaeOrder.ECOSYSTEM_DESC ->
            this.map { it to getString(it.ecosystem) }.sortedByDescending { it.second }.map { it.first }
    }
}

internal suspend fun List<Ectomycorrhiza>.filter(
    query: String,
    filters: Map<EctomycorrhizaeFilterType, EctomycorrhizaeFilter>
): List<Ectomycorrhiza> {
    // Apply selected filters first for better performance
    val typeFilter =
        filters[EctomycorrhizaeFilterType.TYPE] as? EctomycorrhizaeFilter.MultipleSelection
    val hostFilter =
        filters[EctomycorrhizaeFilterType.HOST] as? EctomycorrhizaeFilter.MultipleSelection
    val fungusFilter =
        filters[EctomycorrhizaeFilterType.FUNGUS] as? EctomycorrhizaeFilter.MultipleSelection

    val filteredByFilters = this.filter { item ->
        val typeOk = typeFilter?.selected?.let { it.isEmpty() || item.type.id in it } ?: true
        val hostOk = hostFilter?.selected?.let { it.isEmpty() || item.host.id in it } ?: true
        val fungusOk =
            fungusFilter?.selected?.let { it.isEmpty() || item.fungus.id in it } ?: true
        typeOk && hostOk && fungusOk
    }

    if (query.isBlank()) return filteredByFilters

    val q = query.lowercase()
    return filteredByFilters.filter { item ->
        val haystack = buildString {
            append(item.fungus.name)
            append(' ')
            append(item.host.name)
            append(' ')
            append(item.type.name)
            append(' ')
            append(getString(item.colorDescription))
            append(' ')
            append(getString(item.ecosystem))
            append(' ')
            append(getString(item.morphologicalCharacters))
            append(' ')
            append(getString(item.mantleAnatomicalCharacters))
            if (item.genBankAccessionNumbers.isNotEmpty()) {
                append(' ')
                append(item.genBankAccessionNumbers.joinToString(" "))
            }
            if (item.references.isNotEmpty()) {
                append(' ')
                append(item.references.joinToString(" "))
            }
        }.lowercase()

        haystack.contains(q)
    }
}

internal fun EctomycorrhizaeFilter?.update(options: Set<EctomycorrhizaeFilter.Option>): EctomycorrhizaeFilter {
    val ids = options.map { it.id }
    return when (this) {
        is EctomycorrhizaeFilter.MultipleSelection -> {
            this.copy(
                options = options,
                selected = this.selected.filter { it in ids }.toSet(),
                expanded = this.expanded
            )
        }

        null -> {
            EctomycorrhizaeFilter.MultipleSelection(
                options = options,
                selected = emptySet(),
                expanded = false,
            )
        }
    }
}