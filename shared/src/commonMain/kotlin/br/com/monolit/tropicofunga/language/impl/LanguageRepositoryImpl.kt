package br.com.monolit.tropicofunga.language.impl

import br.com.monolit.tropicofunga.language.Language
import br.com.monolit.tropicofunga.language.LanguageRepository
import br.com.monolit.tropicofunga.language.applyAppLocale
import br.com.monolit.tropicofunga.language.detectSystemLanguageCode
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LanguageRepositoryImpl(
    private val settings: Settings,
) : LanguageRepository {

    private val _currentLanguage = MutableStateFlow(resolveInitialLanguage())
    override val currentLanguage: StateFlow<Language> = _currentLanguage.asStateFlow()

    init {
        // Apply before the first Compose frame is produced (this repository is created eagerly
        // via Koin's createdAtStart, see LanguageModule.kt).
        applyAppLocale(_currentLanguage.value.code)
    }

    private fun resolveInitialLanguage(): Language {
        val stored = settings.getStringOrNull(KEY_LANGUAGE)
        if (stored != null) {
            return Language.fromCode(stored) ?: Language.Default
        }

        // First run: detect the device's language and fall back to the default if unsupported.
        val resolved = Language.fromCode(detectSystemLanguageCode()) ?: Language.Default
        settings.putString(KEY_LANGUAGE, resolved.code)
        return resolved
    }

    override fun setLanguage(language: Language) {
        settings.putString(KEY_LANGUAGE, language.code)
        applyAppLocale(language.code)
        _currentLanguage.update { language }
    }

    private companion object {
        const val KEY_LANGUAGE = "app_language_code"
    }
}
