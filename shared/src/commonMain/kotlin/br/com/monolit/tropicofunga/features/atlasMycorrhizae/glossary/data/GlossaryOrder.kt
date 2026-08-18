package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.order_definition_asc
import tropicofunga.shared.generated.resources.order_definition_desc
import tropicofunga.shared.generated.resources.order_term_asc
import tropicofunga.shared.generated.resources.order_term_desc

enum class GlossaryOrder(val title: StringResource) {
    TERM_ASC(Res.string.order_term_asc),
    TERM_DESC(Res.string.order_term_desc),
    DEFINITION_ASC(Res.string.order_definition_asc),
    DEFINITION_DESC(Res.string.order_definition_desc),
}
