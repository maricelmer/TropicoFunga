package br.com.monolit.tropicofunga.language

/**
 * Returns the two-letter language code (e.g. "en", "pt", "es") the device is currently
 * configured with, used only for first-run language detection.
 */
expect fun detectSystemLanguageCode(): String

/**
 * Applies the given two-letter language code as the app's effective locale, so that
 * subsequent `stringResource`/`getString` calls resolve strings in that language.
 */
expect fun applyAppLocale(languageCode: String)
