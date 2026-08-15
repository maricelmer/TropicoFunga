package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza

sealed interface EctomycorrhizaeViewState {
    data object Loading: EctomycorrhizaeViewState
    data class Loaded(val ectomycorrhizae: List<EctomycorrhizaItem>): EctomycorrhizaeViewState
    data class Error(val message: String): EctomycorrhizaeViewState
}