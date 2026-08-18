package br.com.monolit.tropicofunga.features.shared.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

fun String.toAnnotatedString(): AnnotatedString =
    buildAnnotatedString { append(this@toAnnotatedString) }