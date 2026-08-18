package br.com.monolit.tropicofunga.data.host

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import kotlin.uuid.Uuid

data class HostSpecie(
    val id: Uuid,
    val genus: HostSpecieGenus,
    val epithet: HostSpecieEpithet,
) {
    val name: AnnotatedString
        get() = buildAnnotatedString {
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                append("${genus.name} ${epithet.name}")
            }
        }
}



