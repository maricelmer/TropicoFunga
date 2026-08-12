package br.ufsc.micolab.tropicoecm.navigation.routes

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoutes {

    @Serializable
    data object Home : AppRoutes

    @Serializable
    data object Ectomycorrhizae : AppRoutes

    @Serializable
    data object HowToCollect : AppRoutes

    @Serializable
    data object Glossary : AppRoutes

    @Serializable
    data object Fungi : AppRoutes

    @Serializable
    data object Hosts : AppRoutes

    @Serializable
    data object About : AppRoutes
}