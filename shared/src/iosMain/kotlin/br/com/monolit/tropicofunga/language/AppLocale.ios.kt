package br.com.monolit.tropicofunga.language

import platform.Foundation.NSLocale
import platform.Foundation.NSUserDefaults
import platform.Foundation.preferredLanguages

actual fun detectSystemLanguageCode(): String {
    val preferred = NSLocale.preferredLanguages.firstOrNull() as? String
    return preferred?.substringBefore("-") ?: "en"
}

actual fun applyAppLocale(languageCode: String) {
    // Best effort: persists the choice so it is picked up on next launch. iOS/Foundation does
    // not guarantee NSLocale.preferredLanguages (and therefore stringResource/getString) reflect
    // this change within the current process/session without an app relaunch.
    NSUserDefaults.standardUserDefaults.setObject(listOf(languageCode), forKey = "AppleLanguages")
    NSUserDefaults.standardUserDefaults.synchronize()
}
