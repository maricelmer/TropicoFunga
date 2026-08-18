package br.com.monolit.tropicofunga.language

import br.com.monolit.tropicofunga.language.impl.LanguageRepositoryImpl
import org.koin.dsl.module

val languageModule = module {
    single<LanguageRepository>(createdAtStart = true) {
        LanguageRepositoryImpl(settings = get())
    }
}
