package br.com.monolit.tropicofunga.data.host

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import br.com.monolit.tropicofunga.data.DataImage
import kotlin.uuid.Uuid

data class Host(
    val id: Uuid,
    val specie: HostSpecie,
    val family: HostFamily,
    val image: DataImage? = null,
) {
    val name: AnnotatedString
        get() = buildAnnotatedString {
            append(specie.name)
            append(" (")
            append(family.name)
            append(")")
        }
}