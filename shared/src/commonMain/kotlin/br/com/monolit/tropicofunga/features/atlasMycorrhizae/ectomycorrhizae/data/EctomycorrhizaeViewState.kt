package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data

import br.com.monolit.tropicofunga.data.ectomycorrhiza.EctomycorrhizaItem

sealed interface EctomycorrhizaeViewState {
    data object Loading : EctomycorrhizaeViewState
    data class Loaded(val ectomycorrhizae: List<EctomycorrhizaItem>) : EctomycorrhizaeViewState

    data class Error(val message: String) : EctomycorrhizaeViewState
}