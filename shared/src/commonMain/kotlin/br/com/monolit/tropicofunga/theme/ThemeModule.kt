package br.com.monolit.tropicofunga.theme

import br.com.monolit.tropicofunga.theme.impl.ThemeRepositoryImpl
import org.koin.dsl.module

val themeModule = module {
    single<ThemeRepository> {
        ThemeRepositoryImpl(settings = get())
    }
}
