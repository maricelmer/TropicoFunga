package br.com.monolit.tropicofunga.features.settings.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import br.com.monolit.tropicofunga.features.settings.view.SettingsView
import br.com.monolit.tropicofunga.features.settings.viewModel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

private const val PRIVACY_POLICY_URL = "https://maricelmer.github.io/TropicoFunga/"

@Composable
fun SettingsScreen(
    onBackPressed: () -> Unit,
    viewModel: SettingsViewModel = koinViewModel(),
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()
    val currentTheme by viewModel.currentTheme.collectAsState()
    val uriHandler = LocalUriHandler.current

    SettingsView(
        modifier = Modifier.fillMaxSize(),
        currentLanguage = currentLanguage,
        availableLanguages = viewModel.availableLanguages,
        onLanguageSelected = viewModel::selectLanguage,
        currentTheme = currentTheme,
        availableThemes = viewModel.availableThemes,
        onThemeSelected = viewModel::selectTheme,
        onBackPressed = onBackPressed,
        onOpenPrivacyPolicyRequest = { uriHandler.openUri(PRIVACY_POLICY_URL) },
    )
}
