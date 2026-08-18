package br.com.monolit.tropicofunga.features.settings.viewModel.impl

import br.com.monolit.tropicofunga.features.settings.viewModel.SettingsViewModel
import br.com.monolit.tropicofunga.language.Language
import br.com.monolit.tropicofunga.language.LanguageRepository

class SettingsViewModelImpl(
    private val languageRepository: LanguageRepository,
) : SettingsViewModel() {

    override val currentLanguage = languageRepository.currentLanguage
    override val availableLanguages = Language.entries

    override fun selectLanguage(language: Language) {
        languageRepository.setLanguage(language)
    }
}
