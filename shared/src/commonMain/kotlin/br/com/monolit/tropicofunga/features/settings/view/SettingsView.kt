package br.com.monolit.tropicofunga.features.settings.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.monolit.tropicofunga.features.shared.utils.toAnnotatedString
import br.com.monolit.tropicofunga.features.shared.views.DefaultScaffold
import br.com.monolit.tropicofunga.features.shared.views.appBar.DefaultAppBar
import br.com.monolit.tropicofunga.language.Language
import br.com.monolit.tropicofunga.theme.ThemeOption
import com.example.compose.AppTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.language_name_english
import tropicofunga.shared.generated.resources.language_name_portuguese
import tropicofunga.shared.generated.resources.language_name_spanish
import tropicofunga.shared.generated.resources.language_section_title
import tropicofunga.shared.generated.resources.settings_screen_title
import tropicofunga.shared.generated.resources.theme_option_dark
import tropicofunga.shared.generated.resources.theme_option_light
import tropicofunga.shared.generated.resources.theme_option_system
import tropicofunga.shared.generated.resources.theme_section_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsView(
    modifier: Modifier,
    currentLanguage: Language,
    availableLanguages: List<Language>,
    onLanguageSelected: (Language) -> Unit,
    currentTheme: ThemeOption,
    availableThemes: List<ThemeOption>,
    onThemeSelected: (ThemeOption) -> Unit,
    onBackPressed: () -> Unit,
) {
    DefaultScaffold(
        modifier = modifier,
        topBar = {
            DefaultAppBar(
                title = stringResource(Res.string.settings_screen_title).toAnnotatedString(),
                onBackPressed = onBackPressed,
            )
        },
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = stringResource(Res.string.language_section_title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        ) {
            availableLanguages.forEachIndexed { index, language ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = availableLanguages.size,
                    ),
                    selected = language == currentLanguage,
                    onClick = { onLanguageSelected(language) },
                    label = {
                        Text(text = stringResource(language.displayNameRes()))
                    },
                )
            }
        }

        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = stringResource(Res.string.theme_section_title),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        ) {
            availableThemes.forEachIndexed { index, theme ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = availableThemes.size,
                    ),
                    selected = theme == currentTheme,
                    onClick = { onThemeSelected(theme) },
                    label = {
                        Text(text = stringResource(theme.displayNameRes()))
                    },
                )
            }
        }
    }
}

private fun Language.displayNameRes(): StringResource = when (this) {
    Language.EN -> Res.string.language_name_english
    Language.PT -> Res.string.language_name_portuguese
    Language.ES -> Res.string.language_name_spanish
}

private fun ThemeOption.displayNameRes(): StringResource = when (this) {
    ThemeOption.LIGHT -> Res.string.theme_option_light
    ThemeOption.DARK -> Res.string.theme_option_dark
    ThemeOption.SYSTEM -> Res.string.theme_option_system
}

@Preview(showBackground = true)
@Composable
private fun SettingsPreview() {
    AppTheme(darkTheme = false) {
        SettingsView(
            modifier = Modifier,
            currentLanguage = Language.EN,
            availableLanguages = Language.entries,
            onLanguageSelected = {},
            currentTheme = ThemeOption.SYSTEM,
            availableThemes = ThemeOption.entries,
            onThemeSelected = {},
            onBackPressed = {},
        )
    }
}
