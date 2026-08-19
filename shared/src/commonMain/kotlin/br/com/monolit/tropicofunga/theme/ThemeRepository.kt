package br.com.monolit.tropicofunga.theme

import kotlinx.coroutines.flow.StateFlow

interface ThemeRepository {
    val currentTheme: StateFlow<ThemeOption>

    fun setTheme(theme: ThemeOption)
}
