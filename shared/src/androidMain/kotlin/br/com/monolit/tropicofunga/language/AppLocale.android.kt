package br.com.monolit.tropicofunga.language

import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

// Deliberately reads from Resources.getSystem() rather than java.util.Locale.getDefault():
// once applyAppLocale() has been called, Locale.getDefault() reflects the per-app override
// instead of the device's real system locale, which would break re-detection logic.
actual fun detectSystemLanguageCode(): String =
    Resources.getSystem().configuration.locales[0].language

actual fun applyAppLocale(languageCode: String) {
    AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
}
