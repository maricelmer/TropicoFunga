package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data

import br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza

sealed interface EctomycorrhizaDetailsViewState {
    data object Loading : EctomycorrhizaDetailsViewState
    data class Loaded(val ectomycorrhiza: Ectomycorrhiza) : EctomycorrhizaDetailsViewState

    data class Error(val message: String) : EctomycorrhizaDetailsViewState
}