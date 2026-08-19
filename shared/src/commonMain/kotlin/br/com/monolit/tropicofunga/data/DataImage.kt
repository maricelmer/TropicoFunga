package br.com.monolit.tropicofunga.data

import org.jetbrains.compose.resources.StringResource


data class DataImage(
    val path: String,
    val legend: StringResource,
    val author: String?,
)
