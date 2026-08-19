package br.com.monolit.tropicofunga.features.settings.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.language.Language
import br.com.monolit.tropicofunga.theme.ThemeOption
import kotlinx.coroutines.flow.StateFlow

abstract class SettingsViewModel : ViewModel() {
    abstract val currentLanguage: StateFlow<Language>
    abstract val availableLanguages: List<Language>

    abstract val currentTheme: StateFlow<ThemeOption>
    abstract val availableThemes: List<ThemeOption>

    abstract fun selectLanguage(language: Language)

    abstract fun selectTheme(theme: ThemeOption)
}
