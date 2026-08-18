package br.com.monolit.tropicofunga.features.settings.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import br.com.monolit.tropicofunga.features.settings.view.SettingsView
import br.com.monolit.tropicofunga.features.settings.viewModel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingsScreen(
    onBackPressed: () -> Unit,
    viewModel: SettingsViewModel = koinViewModel(),
) {
    val currentLanguage by viewModel.currentLanguage.collectAsState()

    SettingsView(
        modifier = Modifier.fillMaxSize(),
        currentLanguage = currentLanguage,
        availableLanguages = viewModel.availableLanguages,
        onLanguageSelected = viewModel::selectLanguage,
        onBackPressed = onBackPressed,
    )
}
