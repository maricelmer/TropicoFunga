package br.com.monolit.tropicofunga.features.atlasMycorrhizae.hosts.data

// TODO internationalize
enum class HostsOrder(val title: String) {
    NAME_ASC("Name (A-Z)"),
    NAME_DESC("Name (Z-A)"),
    SPECIE_ASC("Specie (A-Z)"),
    SPECIE_DESC("Species (Z-A)"),
    FAMILY_ASC("Family (A-Z)"),
    FAMILY_DESC("Family (Z-A)"),
}