package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.Fungus
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.Host
import kotlin.uuid.Uuid

data class Ectomycorrhiza(
    val id: Uuid,
    val fungus: Fungus,
    val host: Host,
    val type: EctomycorrhizaType,
    val colorDescription: String,
    val hartigNet: HartigNet,
    val mantleThickness: String,
    val hyphaeMantle: HyphaeMantle,
    val outerMantleLayer: OuterMantleLayer,
    val hyphalStrands: HyphalStrands,
    val ecosystem: String,
    val genBankAccessionNumbers: List<String>,
    val references: List<String>,
    val morphologicalCharacters: String,
    val mantleAnatomicalCharacters: String,
    val photosPaths: List<String>
) {
    val name: String
        get() = "${fungus.name} + ${host.name}"
}

data class EctomycorrhizaItem(
    val id: Uuid,
    val fungus: String,
    val host: String,
    val type: EctomycorrhizaType,
    val ecosystem: String,
    val photoPath: String?,
)

fun List<Ectomycorrhiza>.toItems(): List<EctomycorrhizaItem> = map { it.toItem() }

fun Ectomycorrhiza.toItem(): EctomycorrhizaItem =
    EctomycorrhizaItem(
        id = id,
        fungus = fungus.name,
        host = host.name,
        type = type,
        ecosystem = ecosystem,
        photoPath = photosPaths.firstOrNull(),
    )