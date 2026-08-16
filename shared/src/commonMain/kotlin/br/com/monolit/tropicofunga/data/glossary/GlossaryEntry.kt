package br.com.monolit.tropicofunga.data.glossary

import org.jetbrains.compose.resources.StringResource
import kotlin.uuid.Uuid

data class GlossaryEntry(
    val id: Uuid,
    val term: StringResource,
    val definition: StringResource,
)
