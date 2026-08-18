package br.com.monolit.tropicofunga.navigation.routes

import kotlinx.serialization.Serializable
import kotlin.uuid.Uuid

@Serializable
sealed interface AppRoutes {

    @Serializable
    data object Home : AppRoutes

    @Serializable
    data object Settings : AppRoutes

    @Serializable

    sealed interface Funga : AppRoutes {
        @Serializable
        data object Home : Funga
    }

    @Serializable
    sealed interface AtlasMycorrhizae : AppRoutes {
        @Serializable
        data object Home : AtlasMycorrhizae

        @Serializable
        data object Ectomycorrhizae : AtlasMycorrhizae

        @Serializable
        data class EctomycorrhizaDetails(val id: Uuid) : AtlasMycorrhizae

        @Serializable
        data object HowToCollect : AtlasMycorrhizae

        @Serializable
        data object Glossary : AtlasMycorrhizae

        @Serializable
        data object Fungi : AtlasMycorrhizae

        @Serializable
        data object Hosts : AtlasMycorrhizae

        @Serializable
        data object About : AtlasMycorrhizae
    }
}