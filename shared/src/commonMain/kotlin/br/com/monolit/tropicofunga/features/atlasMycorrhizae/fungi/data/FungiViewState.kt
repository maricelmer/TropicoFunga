package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data

import br.com.monolit.tropicofunga.data.fungus.Fungus

sealed interface FungiViewState {
    data object Loading : FungiViewState
    data class Loaded(val fungi: List<Fungus>) : FungiViewState

    data class Error(val message: String) : FungiViewState
}