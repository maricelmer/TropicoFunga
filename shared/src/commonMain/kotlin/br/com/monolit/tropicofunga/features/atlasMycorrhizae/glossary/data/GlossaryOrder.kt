package br.com.monolit.tropicofunga.features.atlasMycorrhizae.glossary.data

// TODO internationalize
enum class GlossaryOrder(val title: String) {
    TERM_ASC("Term (A-Z)"),
    TERM_DESC("Term (Z-A)"),
    DEFINITION_ASC("Definition (A-Z)"),
    DEFINITION_DESC("Definition (Z-A)"),
}