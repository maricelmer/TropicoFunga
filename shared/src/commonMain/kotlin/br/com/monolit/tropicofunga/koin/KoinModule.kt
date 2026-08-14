package br.com.monolit.tropicofunga.koin

import br.com.monolit.tropicofunga.features.featuresModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initializeKoin(
    specializedModule: Module,
    applyContext: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        applyContext?.invoke(this)
        modules(
            featuresModule,
            specializedModule,
        )
    }
}