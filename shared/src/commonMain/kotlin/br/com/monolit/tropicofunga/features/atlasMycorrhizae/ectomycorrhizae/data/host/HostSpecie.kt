package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host

import kotlin.uuid.Uuid

data class HostSpecie(
    val id: Uuid,
    val genus: HostSpecieGenus,
    val epithet: HostSpecieEpithet,
) {
    val name: String
        get() = "${genus.name} ${epithet.name}"
}



