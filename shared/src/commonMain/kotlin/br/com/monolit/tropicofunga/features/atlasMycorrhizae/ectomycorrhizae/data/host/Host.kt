package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host

import kotlin.uuid.Uuid

data class Host(
    val id: Uuid,
    val specie: HostSpecie,
    val family: HostFamily,
) {
    val name: String
        get() = "${specie.name} (${family.name})"
}