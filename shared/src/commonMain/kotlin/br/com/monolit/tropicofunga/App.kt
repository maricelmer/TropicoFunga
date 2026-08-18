package br.com.monolit.tropicofunga

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.monolit.tropicofunga.language.LanguageRepository
import br.com.monolit.tropicofunga.navigation.main.AppNavHost
import com.example.compose.AppTheme
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    val languageRepository = koinInject<LanguageRepository>()
    val currentLanguage by languageRepository.currentLanguage.collectAsState()
    // Created outside key() so the back stack survives a language change.
    val navHostController = rememberNavController()

    AppTheme {
        // Forces the whole nav graph (and every stringResource() call inside it) to be
        // discarded and rebuilt when the language changes, so the new locale is reflected
        // immediately even on platforms without automatic recreation (Desktop/iOS).
        key(currentLanguage) {
            AppNavHost(
                modifier = Modifier.fillMaxSize(),
                navHostController = navHostController,
            )
        }
    }
}
