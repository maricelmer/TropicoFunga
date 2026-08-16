package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizaDetails.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.viewstate.EctomycorrhizaDetailsViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaDetailsViewModel
import br.com.monolit.tropicofunga.repository.AppRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.uuid.Uuid

class EctomycorrhizaDetailsViewModelImpl(
    private val id: Uuid,
    private val repository: AppRepository,
) : EctomycorrhizaDetailsViewModel() {

    private val _viewState =
        MutableStateFlow<EctomycorrhizaDetailsViewState>(EctomycorrhizaDetailsViewState.Loading)
    override val viewState = _viewState.asStateFlow()

    init {
        load()
    }

    var loadJob: Job? = null
    override fun load() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            repository.loadEctomycorrhiza(id)
                .onSuccess { ectomycorrhiza ->
                    _viewState.update {
                        if (ectomycorrhiza != null) {
                            EctomycorrhizaDetailsViewState.Loaded(ectomycorrhiza = ectomycorrhiza)
                        } else {
                            // TODO internationalize error message
                            EctomycorrhizaDetailsViewState.Error("Ectomycorrhiza not found")
                        }
                    }
                }
                .onFailure { exception ->
                    // TODO internationalize error message
                    _viewState.update { EctomycorrhizaDetailsViewState.Error("Failed to load ectomycorrhiza") }
                    println("Error occurred while loading ectomycorrhizae: ${exception.message}")
                }
        }
    }
}