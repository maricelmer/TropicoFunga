package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizaDetails.viewModel.impl

import androidx.lifecycle.viewModelScope
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaDetailsViewState
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaDetailsViewModel
import br.com.monolit.tropicofunga.repository.AppRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.ectomycorrhiza_not_found_error
import tropicofunga.shared.generated.resources.failed_to_load_ectomycorrhiza_error
import kotlin.uuid.Uuid

class EctomycorrhizaDetailsViewModelImpl(
    private val id: Uuid,
    private val repository: AppRepository,
) : EctomycorrhizaDetailsViewModel() {

    private val _viewState =
        MutableStateFlow<EctomycorrhizaDetailsViewState>(
            EctomycorrhizaDetailsViewState.Loading
        )
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
                            EctomycorrhizaDetailsViewState.Error(getString(Res.string.ectomycorrhiza_not_found_error))
                        }
                    }
                }
                .onFailure { exception ->
                    _viewState.update {
                        EctomycorrhizaDetailsViewState.Error(getString(Res.string.failed_to_load_ectomycorrhiza_error))
                    }
                    println("Error occurred while loading ectomycorrhizae: ${exception.message}")
                }
        }
    }
}