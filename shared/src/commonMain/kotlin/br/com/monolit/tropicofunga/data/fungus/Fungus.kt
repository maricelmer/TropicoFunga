package br.com.monolit.tropicofunga.data.fungus

import br.com.monolit.tropicofunga.data.DataImage
import kotlin.uuid.Uuid

data class Fungus(
    val id: Uuid,
    val specie: FungusSpecie,
    val family: FungusFamily,
    val image: DataImage,
) {
    val name: String
        get() = "${specie.name} (${family.name})"
}