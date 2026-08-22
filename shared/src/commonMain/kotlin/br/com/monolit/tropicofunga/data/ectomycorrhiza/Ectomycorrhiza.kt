package br.com.monolit.tropicofunga.data.ectomycorrhiza

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import br.com.monolit.tropicofunga.data.DataImage
import br.com.monolit.tropicofunga.data.fungus.Fungus
import br.com.monolit.tropicofunga.data.host.Host
import org.jetbrains.compose.resources.StringResource
import kotlin.uuid.Uuid

data class Ectomycorrhiza(
    val id: Uuid,
    val fungus: Fungus,
    val host: Host,
    val type: EctomycorrhizaType,
    val colorDescription: StringResource,
    val hartigNet: HartigNet,
    val mantleThickness: String,
    val hyphaeMantle: HyphaeMantle,
    val outerMantleLayer: OuterMantleLayer,
    val hyphalStrands: HyphalStrands,
    val ecosystem: StringResource,
    val genBankAccessionNumbers: List<String>,
    val references: List<String>,
    val morphologicalCharacters: StringResource,
    val mantleAnatomicalCharacters: StringResource,
    val images: List<DataImage>
) {
    val name: AnnotatedString
        get() = buildAnnotatedString{
            append(fungus.name)
            append(" + ")
            append(host.name)
        }
}

data class EctomycorrhizaItem(
    val id: Uuid,
    val fungus: AnnotatedString,
    val host: AnnotatedString,
    val type: EctomycorrhizaType,
    val ecosystem: StringResource,
    val image: DataImage?,
)

fun List<Ectomycorrhiza>.toItems(): List<EctomycorrhizaItem> =
    map { it.toItem() }

fun Ectomycorrhiza.toItem(): EctomycorrhizaItem = EctomycorrhizaItem(
    id = id,
    fungus = fungus.name,
    host = host.name,
    type = type,
    ecosystem = ecosystem,
    image = images.firstOrNull(),
)