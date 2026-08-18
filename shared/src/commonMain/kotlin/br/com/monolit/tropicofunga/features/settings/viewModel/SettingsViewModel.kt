package br.com.monolit.tropicofunga.features.settings.viewModel

import androidx.lifecycle.ViewModel
import br.com.monolit.tropicofunga.language.Language
import kotlinx.coroutines.flow.StateFlow

abstract class SettingsViewModel : ViewModel() {
    abstract val currentLanguage: StateFlow<Language>
    abstract val availableLanguages: List<Language>

    abstract fun selectLanguage(language: Language)
}
