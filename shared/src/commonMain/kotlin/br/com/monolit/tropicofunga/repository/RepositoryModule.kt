package br.com.monolit.tropicofunga.repository

import br.com.monolit.tropicofunga.repository.impl.StaticDataAppRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AppRepository>() {
        StaticDataAppRepositoryImpl()
    }
}