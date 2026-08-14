package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.fungus
import tropicofunga.shared.generated.resources.host

sealed interface EctomycorrhizaeFilter {
    val expanded: Boolean

    data class MultipleSelection(
        override val expanded: Boolean,
        val selected: Set<Int>,
        val options: List<String>,
    ) : EctomycorrhizaeFilter
}

enum class EctomycorrhizaeFilterType(val title: StringResource) {
    HOST(Res.string.host),
    FUNGUS(Res.string.fungus)
}

