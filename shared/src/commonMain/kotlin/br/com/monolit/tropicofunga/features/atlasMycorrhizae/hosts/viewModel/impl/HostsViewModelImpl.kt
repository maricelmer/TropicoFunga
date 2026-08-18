package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.data.host.Host
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilter
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsFilterType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data.HostsViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.viewModel.HostsViewModel
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
import org.jetbrains.compose.resources.getString
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.failed_to_load_hosts_error

class HostsViewModelImpl(
    private val repository: AppRepository,
) : HostsViewModel() {

    override val searchQuery = MutableStateFlow("")

    override val filters =
        MutableStateFlow<PersistentMap<HostsFilterType, HostsFilter>>(
            persistentMapOf()
        )

    override val ordersList = HostsOrder.entries
    override val selectedOrder = MutableStateFlow(HostsOrder.NAME_ASC)

    private val _viewState = MutableStateFlow<HostsViewState>(HostsViewState.Loading)
    override val viewState = combine(
        _viewState,
        selectedOrder,
    ) { state, order ->
        when (state) {
            HostsViewState.Loading -> state
            is HostsViewState.Error -> state
            is HostsViewState.Loaded -> {
                HostsViewState.Loaded(hosts = state.hosts.order(order))
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, HostsViewState.Loading)

    init {
        load()
    }

    var loadJob: Job? = null
    override fun load() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            repository.loadHosts()
                .onSuccess { hosts ->
                    val specie = mutableSetOf<HostsFilter.Option>()
                    val families = mutableSetOf<HostsFilter.Option>()

                    hosts.forEach { host ->
                        specie.add(
                            HostsFilter.Option(
                                id = host.specie.id,
                                name = host.specie.name
                            )
                        )
                        families.add(
                            HostsFilter.Option(
                                id = host.family.id,
                                name = host.family.name.toAnnotatedString()
                            )
                        )
                    }

                    filters.update {
                        val specieFilter = it[HostsFilterType.SPECIE].update(options = specie)
                        val familyFilter = it[HostsFilterType.FAMILY].update(options = families)

                        it.putting(HostsFilterType.SPECIE, specieFilter)
                            .putting(HostsFilterType.FAMILY, familyFilter)
                    }

                    combine(
                        searchQuery,
                        filters,
                    ) { query, filtersList ->
                        query to filtersList
                    }.collect { (query, filtersList) ->
                        _viewState.update { HostsViewState.Loading }
                        _viewState.update {
                            HostsViewState.Loaded(
                                hosts = hosts.filter(query, filtersList)
                            )
                        }
                    }
                }
                .onFailure { exception ->
                    _viewState.update { HostsViewState.Error(getString(Res.string.failed_to_load_hosts_error)) }
                    println("Error occurred while loading hosts: ${exception.message}")
                }
        }
    }

    override fun changeQuery(query: String) {
        searchQuery.update { query }
    }

    override fun updateFilter(
        filterType: HostsFilterType,
        filter: HostsFilter
    ) {
        filters.update { it.putting(filterType, filter) }
    }

    override fun updateOrder(order: HostsOrder) {
        selectedOrder.update { order }
    }
}

internal fun List<Host>.order(order: HostsOrder): List<Host> {
    return when (order) {
        HostsOrder.NAME_ASC -> this.sortedBy { it.name.text }
        HostsOrder.NAME_DESC -> this.sortedByDescending { it.name.text }
        HostsOrder.SPECIE_ASC -> this.sortedBy { it.specie.name.text }
        HostsOrder.SPECIE_DESC -> this.sortedByDescending { it.specie.name.text }
        HostsOrder.FAMILY_ASC -> this.sortedBy { it.family.name }
        HostsOrder.FAMILY_DESC -> this.sortedByDescending { it.family.name }
    }
}

internal fun List<Host>.filter(
    query: String,
    filters: Map<HostsFilterType, HostsFilter>
): List<Host> {
    // Apply selected filters first for better performance
    val specieFilter = filters[HostsFilterType.SPECIE] as? HostsFilter.MultipleSelection
    val familyFilter = filters[HostsFilterType.FAMILY] as? HostsFilter.MultipleSelection

    val filteredByFilters = this.filter { item ->
        val specieOk = specieFilter?.selected?.let { it.isEmpty() || item.specie.id in it } ?: true
        val familyOk = familyFilter?.selected?.let { it.isEmpty() || item.family.id in it } ?: true
        specieOk && familyOk
    }

    if (query.isBlank()) return filteredByFilters

    val q = query.lowercase()
    return filteredByFilters.filter { item ->
        item.name.text.lowercase().contains(q)
    }
}

internal fun HostsFilter?.update(options: Set<HostsFilter.Option>): HostsFilter {
    val ids = options.map { it.id }
    return when (this) {
        is HostsFilter.MultipleSelection -> {
            this.copy(
                options = options,
                selected = this.selected.filter { it in ids }.toSet(),
                expanded = this.expanded
            )
        }

        null -> {
            HostsFilter.MultipleSelection(
                options = options,
                selected = emptySet(),
                expanded = false,
            )
        }
    }
}