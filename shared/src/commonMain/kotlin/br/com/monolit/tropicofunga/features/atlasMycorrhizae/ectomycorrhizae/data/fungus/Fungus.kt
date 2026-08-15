package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus

import kotlin.uuid.Uuid

data class Fungus(
    val id: Uuid,
    val name: String,
    val family: FungusFamily,
)