package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data

import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry

sealed interface GlossaryViewState {
    data object Loading : GlossaryViewState
    data class Loaded(val glossary: List<GlossaryEntry>) : GlossaryViewState
    data class Error(val message: String) : GlossaryViewState
}