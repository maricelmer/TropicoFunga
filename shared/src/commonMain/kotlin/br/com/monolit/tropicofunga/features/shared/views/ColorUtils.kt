package br.com.monolit.tropicofunga.features.shared.views

import androidx.compose.ui.graphics.Color

fun getColorFromText(text: String): Color {
    // Calculate a deterministic hash from the string
    val longHash = text.fold(0L) { acc, c -> acc * 31L + c.code }
    val hash = (longHash and 0xffffffffL).toInt()

    // Derive RGB channels from hash
    var r = (hash shr 16) and 0xFF
    var g = (hash shr 8) and 0xFF
    var b = hash and 0xFF

    // Normalize channels to avoid colors that are too dark or too light
    val min = 70
    val max = 210
    val range = max - min + 1
    r = (r % range) + min
    g = (g % range) + min
    b = (b % range) + min

    val colorInt = (0xFF shl 24) or (r shl 16) or (g shl 8) or b
    return Color(colorInt)
}