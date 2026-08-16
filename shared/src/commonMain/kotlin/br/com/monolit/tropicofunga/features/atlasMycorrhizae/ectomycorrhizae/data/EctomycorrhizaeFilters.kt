package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.fungus
import tropicofunga.shared.generated.resources.host
import tropicofunga.shared.generated.resources.type
import kotlin.uuid.Uuid

sealed interface EctomycorrhizaeFilter {
    val expanded: Boolean

    data class MultipleSelection(
        override val expanded: Boolean,
        val selected: Set<Uuid>,
        val options: Set<Option>,
    ) : EctomycorrhizaeFilter

    data class Option(val id: Uuid, val name: String)
}

enum class EctomycorrhizaeFilterType(val title: StringResource) {
    TYPE(Res.string.type),
    HOST(Res.string.host),
    FUNGUS(Res.string.fungus)
}

