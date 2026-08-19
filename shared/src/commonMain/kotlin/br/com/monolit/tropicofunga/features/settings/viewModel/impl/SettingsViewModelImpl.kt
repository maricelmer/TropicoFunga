package br.com.monolit.tropicofunga.features.settings.viewModel.impl

import br.com.monolit.tropicofunga.features.settings.viewModel.SettingsViewModel
import br.com.monolit.tropicofunga.language.Language
import br.com.monolit.tropicofunga.language.LanguageRepository
import br.com.monolit.tropicofunga.theme.ThemeOption
import br.com.monolit.tropicofunga.theme.ThemeRepository

class SettingsViewModelImpl(
    private val languageRepository: LanguageRepository,
    private val themeRepository: ThemeRepository,
) : SettingsViewModel() {

    override val currentLanguage = languageRepository.currentLanguage
    override val availableLanguages = Language.entries

    override val currentTheme = themeRepository.currentTheme
    override val availableThemes = ThemeOption.entries

    override fun selectLanguage(language: Language) {
        languageRepository.setLanguage(language)
    }

    override fun selectTheme(theme: ThemeOption) {
        themeRepository.setTheme(theme)
    }
}
