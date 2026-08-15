package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza

// TODO internationalize
enum class EctomycorrhizaeOrder(val title: String) {
    FUNGUS_ASC("Fungus (A-Z)"),
    FUNGUS_DESC("Fungus (Z-A)"),
    HOST_ASC("Host (A-Z)"),
    HOST_DESC("Host (Z-A)"),
    TYPE_ASC("Type (A-Z)"),
    TYPE_DESC("Type (Z-A)"),
    ECOSYSTEM_ASC("Ecosystem (A-Z)"),
    ECOSYSTEM_DESC("Ecosystem (Z-A)")
}