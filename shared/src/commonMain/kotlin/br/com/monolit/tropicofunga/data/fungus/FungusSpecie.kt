package br.com.monolit.tropicofunga.data.fungus

import kotlin.uuid.Uuid

data class FungusSpecie(
    val id: Uuid,
    val genus: FungusSpecieGenus,
    val epithet: FungusSpecieEpithet,
) {
    val name: String
        get() = "${genus.name} ${epithet.name}"
}



