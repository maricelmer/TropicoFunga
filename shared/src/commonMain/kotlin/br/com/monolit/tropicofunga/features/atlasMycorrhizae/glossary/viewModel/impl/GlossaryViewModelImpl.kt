package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryOrder
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data.GlossaryViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.viewModel.GlossaryViewModel
import br.com.monolit.tropicofunga.log.AppLogger
import br.com.monolit.tropicofunga.repository.AppRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.failed_to_load_glossary_error

class GlossaryViewModelImpl(
    private val repository: AppRepository,
) : GlossaryViewModel() {

    override val searchQuery = MutableStateFlow("")

    override val ordersList = GlossaryOrder.entries
    override val selectedOrder = MutableStateFlow(GlossaryOrder.TERM_ASC)

    private val _viewState = MutableStateFlow<GlossaryViewState>(GlossaryViewState.Loading)
    override val viewState = combine(
        _viewState,
        selectedOrder,
    ) { state, order ->
        when (state) {
            GlossaryViewState.Loading -> state
            is GlossaryViewState.Error -> state
            is GlossaryViewState.Loaded -> {
                GlossaryViewState.Loaded(
                    glossary = state.glossary.order(order)
                )
            }
        }
    }.stateIn(viewModelScope, SharingStarted.Eagerly, GlossaryViewState.Loading)

    init {
        load()
    }

    var loadJob: Job? = null
    override fun load() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            repository.loadGlossary()
                .onSuccess { glossary ->

                    searchQuery.collect { query ->
                        _viewState.update { GlossaryViewState.Loading }
                        _viewState.update {
                            GlossaryViewState.Loaded(
                                glossary = glossary.filter(query)
                            )
                        }
                    }
                }
                .onFailure { exception ->
                    _viewState.update { GlossaryViewState.Error(getString(Res.string.failed_to_load_glossary_error)) }
                    AppLogger.e("GlossaryViewModel", "Error occurred while loading glossary", exception)
                }
        }
    }

    override fun changeQuery(query: String) {
        searchQuery.update { query }
    }

    override fun updateOrder(order: GlossaryOrder) {
        selectedOrder.update { order }
    }
}

internal suspend fun List<GlossaryEntry>.order(order: GlossaryOrder): List<GlossaryEntry> {
    return when (order) {
        GlossaryOrder.TERM_ASC -> this.map { it to getString(it.term) }.sortedBy { it.second }.map { it.first }
        GlossaryOrder.TERM_DESC -> this.map { it to getString(it.term) }.sortedByDescending { it.second }.map { it.first }
        GlossaryOrder.DEFINITION_ASC -> this.map { it to getString(it.definition) }.sortedBy { it.second }.map { it.first }
        GlossaryOrder.DEFINITION_DESC -> this.map { it to getString(it.definition) }.sortedByDescending { it.second }.map { it.first }
    }
}

internal suspend fun List<GlossaryEntry>.filter(query: String): List<GlossaryEntry> {
    if (query.isBlank()) return this

    val q = query.lowercase()

    return this.filter { item ->
        val haystack = buildString {
            append(getString(item.term))
            append(' ')
            append(getString(item.definition))
        }.lowercase()
        haystack.contains(q)
    }
}