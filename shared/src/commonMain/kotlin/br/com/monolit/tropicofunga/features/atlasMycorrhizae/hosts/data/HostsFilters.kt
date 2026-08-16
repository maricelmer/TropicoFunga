package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.family
import tropicofunga.shared.generated.resources.specie
import kotlin.uuid.Uuid

sealed interface HostsFilter {
    val expanded: Boolean

    data class MultipleSelection(
        override val expanded: Boolean,
        val selected: Set<Uuid>,
        val options: Set<Option>,
    ) : HostsFilter

    data class Option(val id: Uuid, val name: String)
}

enum class HostsFilterType(val title: StringResource) {
    SPECIE(Res.string.specie),
    FAMILY(Res.string.family),
}