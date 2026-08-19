package br.com.monolit.tropicofunga.theme.impl

import br.com.monolit.tropicofunga.theme.ThemeOption
import br.com.monolit.tropicofunga.theme.ThemeRepository
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ThemeRepositoryImpl(
    private val settings: Settings,
) : ThemeRepository {

    private val _currentTheme = MutableStateFlow(resolveInitialTheme())
    override val currentTheme: StateFlow<ThemeOption> = _currentTheme.asStateFlow()

    private fun resolveInitialTheme(): ThemeOption {
        val stored = settings.getStringOrNull(KEY_THEME)
        return ThemeOption.fromName(stored) ?: ThemeOption.Default
    }

    override fun setTheme(theme: ThemeOption) {
        settings.putString(KEY_THEME, theme.name)
        _currentTheme.update { theme }
    }

    private companion object {
        const val KEY_THEME = "app_theme_option"
    }
}
