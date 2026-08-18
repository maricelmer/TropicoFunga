package br.com.monolit.tropicofunga.language

import kotlinx.coroutines.flow.StateFlow

interface LanguageRepository {
    val currentLanguage: StateFlow<Language>

    fun setLanguage(language: Language)
}
