package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.EctomycorrhizaDetailsViewState
import kotlinx.coroutines.flow.StateFlow

abstract class EctomycorrhizaDetailsViewModel : ViewModel() {

    abstract val viewState: StateFlow<EctomycorrhizaDetailsViewState>

    abstract fun load()
}