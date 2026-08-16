package br.com.monolit.tropicofunga.data.fungus

import kotlin.uuid.Uuid

data class FungusSpecieEpithet(
    val id: Uuid,
    val name: String,
)