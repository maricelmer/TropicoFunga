package br.com.monolit.tropicofunga.features.atlasMycorrhizae.fungi.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.order_family_asc
import tropicofunga.shared.generated.resources.order_family_desc
import tropicofunga.shared.generated.resources.order_name_asc
import tropicofunga.shared.generated.resources.order_name_desc
import tropicofunga.shared.generated.resources.order_specie_asc
import tropicofunga.shared.generated.resources.order_specie_desc

enum class FungiOrder(val title: StringResource) {
    NAME_ASC(Res.string.order_name_asc),
    NAME_DESC(Res.string.order_name_desc),
    SPECIE_ASC(Res.string.order_specie_asc),
    SPECIE_DESC(Res.string.order_specie_desc),
    FAMILY_ASC(Res.string.order_family_asc),
    FAMILY_DESC(Res.string.order_family_desc),
}
