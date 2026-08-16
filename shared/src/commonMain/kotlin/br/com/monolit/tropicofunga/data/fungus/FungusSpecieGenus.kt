package br.com.monolit.tropicofunga.data.fungus

import kotlin.uuid.Uuid

data class FungusSpecieGenus(
    val id: Uuid,
    val name: String,
)