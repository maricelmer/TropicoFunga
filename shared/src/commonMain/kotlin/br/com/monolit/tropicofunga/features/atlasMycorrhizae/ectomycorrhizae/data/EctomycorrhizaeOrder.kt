package br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data

import org.jetbrains.compose.resources.StringResource
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.order_ecosystem_asc
import tropicofunga.shared.generated.resources.order_ecosystem_desc
import tropicofunga.shared.generated.resources.order_fungus_asc
import tropicofunga.shared.generated.resources.order_fungus_desc
import tropicofunga.shared.generated.resources.order_host_asc
import tropicofunga.shared.generated.resources.order_host_desc
import tropicofunga.shared.generated.resources.order_type_asc
import tropicofunga.shared.generated.resources.order_type_desc

enum class EctomycorrhizaeOrder(val title: StringResource) {
    FUNGUS_ASC(Res.string.order_fungus_asc),
    FUNGUS_DESC(Res.string.order_fungus_desc),
    HOST_ASC(Res.string.order_host_asc),
    HOST_DESC(Res.string.order_host_desc),
    TYPE_ASC(Res.string.order_type_asc),
    TYPE_DESC(Res.string.order_type_desc),
    ECOSYSTEM_ASC(Res.string.order_ecosystem_asc),
    ECOSYSTEM_DESC(Res.string.order_ecosystem_desc)
}
