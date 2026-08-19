package br.com.monolit.tropicofunga.features.shared.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle

fun String.toAnnotatedString(): AnnotatedString =
    buildAnnotatedString { append(this@toAnnotatedString) }

private val italicTagRegex = Regex("<i>(.*?)</i>", RegexOption.DOT_MATCHES_ALL)

/**
 * Parses `<i>` / `</i>` tags in this string (e.g. coming from a translated string resource)
 * into an [AnnotatedString] where the wrapped text is italicized, such as a species name.
 */
fun String.toAnnotatedStringWithItalics(): AnnotatedString = buildAnnotatedString {
    var lastIndex = 0
    for (match in italicTagRegex.findAll(this@toAnnotatedStringWithItalics)) {
        append(this@toAnnotatedStringWithItalics.substring(lastIndex, match.range.first))
        withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
            append(match.groupValues[1])
        }
        lastIndex = match.range.last + 1
    }
    append(this@toAnnotatedStringWithItalics.substring(lastIndex))
}