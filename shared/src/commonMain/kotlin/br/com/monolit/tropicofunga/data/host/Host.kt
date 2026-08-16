package br.com.monolit.tropicofunga.data.host

import br.com.monolit.tropicofunga.data.DataImage
import kotlin.uuid.Uuid

data class Host(
    val id: Uuid,
    val specie: HostSpecie,
    val family: HostFamily,
    val image: DataImage,
) {
    val name: String
        get() = "${specie.name} (${family.name})"
}