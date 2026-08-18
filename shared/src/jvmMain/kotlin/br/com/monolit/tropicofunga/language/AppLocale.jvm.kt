package br.com.monolit.tropicofunga.language

import java.util.Locale

actual fun detectSystemLanguageCode(): String = Locale.getDefault().language

actual fun applyAppLocale(languageCode: String) {
    Locale.setDefault(Locale.forLanguageTag(languageCode))
}
