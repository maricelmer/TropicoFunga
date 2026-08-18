package br.com.monolit.tropicofunga.data.fungus

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import br.com.monolit.tropicofunga.data.DataImage
import kotlin.uuid.Uuid

data class Fungus(
    val id: Uuid,
    val specie: FungusSpecie?,
    val family: FungusFamily,
    val image: DataImage? = null,
) {
    val name: AnnotatedString
        get() = buildAnnotatedString {
            if (specie != null) {
                append(specie.name)
                append(" (")
            }
            append(family.name)
            if (specie != null) {
                append(")")
            }
        }
}