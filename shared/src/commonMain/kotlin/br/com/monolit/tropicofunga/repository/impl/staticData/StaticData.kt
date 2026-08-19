package br.com.monolit.tropicofunga.repository.impl.staticData

import br.com.monolit.tropicofunga.data.DataImage
import br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.data.ectomycorrhiza.EctomycorrhizaType
import br.com.monolit.tropicofunga.data.ectomycorrhiza.HartigNet
import br.com.monolit.tropicofunga.data.ectomycorrhiza.HyphaeMantle
import br.com.monolit.tropicofunga.data.ectomycorrhiza.HyphalStrands
import br.com.monolit.tropicofunga.data.ectomycorrhiza.OuterMantleLayer
import br.com.monolit.tropicofunga.data.fungus.Fungus
import br.com.monolit.tropicofunga.data.fungus.FungusFamily
import br.com.monolit.tropicofunga.data.fungus.FungusSpecie
import br.com.monolit.tropicofunga.data.fungus.FungusSpecieEpithet
import br.com.monolit.tropicofunga.data.fungus.FungusSpecieGenus
import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry
import br.com.monolit.tropicofunga.data.host.Host
import br.com.monolit.tropicofunga.data.host.HostFamily
import br.com.monolit.tropicofunga.data.host.HostSpecie
import br.com.monolit.tropicofunga.data.host.HostSpecieEpithet
import br.com.monolit.tropicofunga.data.host.HostSpecieGenus
import tropicofunga.shared.generated.resources.Res
import tropicofunga.shared.generated.resources.agglutinated_definition
import tropicofunga.shared.generated.resources.agglutinated_term
import tropicofunga.shared.generated.resources.clamp_or_clamp_connection_definition
import tropicofunga.shared.generated.resources.clamp_or_clamp_connection_term
import tropicofunga.shared.generated.resources.cortex_definition
import tropicofunga.shared.generated.resources.cortex_term
import tropicofunga.shared.generated.resources.cystidia_definition
import tropicofunga.shared.generated.resources.cystidia_term
import tropicofunga.shared.generated.resources.dichotomous_ectomycorrhizae_definition
import tropicofunga.shared.generated.resources.dichotomous_ectomycorrhizae_term
import tropicofunga.shared.generated.resources.ecm_legend_clavulina_a
import tropicofunga.shared.generated.resources.ecm_legend_clavulina_b
import tropicofunga.shared.generated.resources.ecm_legend_clavulina_c
import tropicofunga.shared.generated.resources.ecm_legend_clavulina_d
import tropicofunga.shared.generated.resources.ecm_legend_clavulina_e
import tropicofunga.shared.generated.resources.ecm_legend_inocybe_a
import tropicofunga.shared.generated.resources.ecm_legend_inocybe_b
import tropicofunga.shared.generated.resources.ecm_legend_inocybe_c
import tropicofunga.shared.generated.resources.ecm_legend_inocybe_d
import tropicofunga.shared.generated.resources.ecm_legend_inocybe_e
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp1_a
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp1_b
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp1_c
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp1_d
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp1_e
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp2_a
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp2_b
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp2_c
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp2_d
import tropicofunga.shared.generated.resources.ecm_legend_thelephora_sp2_e
import tropicofunga.shared.generated.resources.ecm_legend_thelephoraceae_sp_a
import tropicofunga.shared.generated.resources.ecm_legend_thelephoraceae_sp_b
import tropicofunga.shared.generated.resources.ecm_legend_thelephoraceae_sp_c
import tropicofunga.shared.generated.resources.ecm_legend_thelephoraceae_sp_d
import tropicofunga.shared.generated.resources.ecm_legend_thelephoraceae_sp_e
import tropicofunga.shared.generated.resources.emanating_hyphae_definition
import tropicofunga.shared.generated.resources.emanating_hyphae_term
import tropicofunga.shared.generated.resources.epidermis_definition
import tropicofunga.shared.generated.resources.epidermis_term
import tropicofunga.shared.generated.resources.example_legend
import tropicofunga.shared.generated.resources.fungus_legend_amanita_cf_calochroa
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp1
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp2
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp3
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp4
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp5
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp6
import tropicofunga.shared.generated.resources.fungus_legend_amanita_sp7
import tropicofunga.shared.generated.resources.fungus_legend_amanita_viscidolutea
import tropicofunga.shared.generated.resources.fungus_legend_austroboletus_festivus
import tropicofunga.shared.generated.resources.fungus_legend_brasilioporus_sp
import tropicofunga.shared.generated.resources.fungus_legend_cantharellus_guyanensis
import tropicofunga.shared.generated.resources.fungus_legend_cantharellus_sp
import tropicofunga.shared.generated.resources.fungus_legend_clavulina_sp
import tropicofunga.shared.generated.resources.fungus_legend_cortinarius_sp
import tropicofunga.shared.generated.resources.fungus_legend_inocybe_sp1
import tropicofunga.shared.generated.resources.fungus_legend_inocybe_sp2
import tropicofunga.shared.generated.resources.fungus_legend_inocybe_sp3
import tropicofunga.shared.generated.resources.fungus_legend_lactifluus_catarinensis
import tropicofunga.shared.generated.resources.fungus_legend_pisolithus_tinctorius
import tropicofunga.shared.generated.resources.fungus_legend_russula_puiggarii
import tropicofunga.shared.generated.resources.fungus_legend_russula_rubropunctatissima
import tropicofunga.shared.generated.resources.fungus_legend_russula_sp1
import tropicofunga.shared.generated.resources.fungus_legend_russula_sp2
import tropicofunga.shared.generated.resources.fungus_legend_russula_sp3
import tropicofunga.shared.generated.resources.fungus_legend_thelephora_sp1
import tropicofunga.shared.generated.resources.fungus_legend_thelephora_sp2
import tropicofunga.shared.generated.resources.fungus_legend_thelephora_terrestris
import tropicofunga.shared.generated.resources.gelatinous_hyphae_definition
import tropicofunga.shared.generated.resources.gelatinous_hyphae_term
import tropicofunga.shared.generated.resources.hartig_net_definition
import tropicofunga.shared.generated.resources.hartig_net_term
import tropicofunga.shared.generated.resources.hyphal_strands_definition
import tropicofunga.shared.generated.resources.hyphal_strands_term
import tropicofunga.shared.generated.resources.mantle_mycorrhizal_mantle_definition
import tropicofunga.shared.generated.resources.mantle_mycorrhizal_mantle_term
import tropicofunga.shared.generated.resources.matrix_matrix_gelatinous_definition
import tropicofunga.shared.generated.resources.matrix_matrix_gelatinous_term
import tropicofunga.shared.generated.resources.mycorrhiza_mycorrhizal_tip_definition
import tropicofunga.shared.generated.resources.mycorrhiza_mycorrhizal_tip_term
import tropicofunga.shared.generated.resources.mycorrhizal_system_definition
import tropicofunga.shared.generated.resources.mycorrhizal_system_term
import tropicofunga.shared.generated.resources.outer_surface_of_mantle_definition
import tropicofunga.shared.generated.resources.outer_surface_of_mantle_term
import tropicofunga.shared.generated.resources.parenchyma_definition
import tropicofunga.shared.generated.resources.parenchyma_term
import tropicofunga.shared.generated.resources.plan_view_definition
import tropicofunga.shared.generated.resources.plan_view_term
import tropicofunga.shared.generated.resources.plectenchymatous_definition
import tropicofunga.shared.generated.resources.plectenchymatous_term
import tropicofunga.shared.generated.resources.pseudoparenchymatous_definition
import tropicofunga.shared.generated.resources.pseudoparenchymatous_term
import tropicofunga.shared.generated.resources.root_hair_definition
import tropicofunga.shared.generated.resources.root_hair_term
import tropicofunga.shared.generated.resources.transverse_section_definition
import tropicofunga.shared.generated.resources.transverse_section_term
import kotlin.uuid.Uuid

val examplePhoto = DataImage(
    path = "files/example/example.png",
    legend = Res.string.example_legend,
    author = "Author Example",
)

val guapirioidType = EctomycorrhizaType(
    id = Uuid.random(),
    name = "Guapirioid"
)

val ectomycorrhizaTypesData = listOf(guapirioidType)

val amanitaGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Amanita"
)
val austroboletusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Austroboletus"
)
val brasilioporusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Brasilioporus"
)
val cantharellusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Cantharellus"
)
val thelephoraGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Thelephora"
)
val inocybeGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Inocybe"
)
val lactifluusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Lactifluus"
)
val pisolithusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Pisolithus"
)
val russulaGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Russula"
)
val clavulinaGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Clavulina"
)
val cortinariusGenus = FungusSpecieGenus(
    id = Uuid.random(),
    name = "Cortinarius"
)

val fungusSpecieGenusListData = listOf(
    amanitaGenus,
    austroboletusGenus,
    brasilioporusGenus,
    cantharellusGenus,
    thelephoraGenus,
    inocybeGenus,
    lactifluusGenus,
    pisolithusGenus,
    russulaGenus,
    clavulinaGenus,
    cortinariusGenus,
)

val spEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp."
)
val sp1Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.1"
)
val sp2Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.2"
)
val sp3Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.3"
)
val sp4Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.4"
)
val sp5Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.5"
)
val sp6Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.6"
)
val sp7Epithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "sp.7"
)
val viscidoluteaEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "viscidolutea"
)
val festivusEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "festivus"
)
val quyanensisEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "quyanensis"
)
val calochroaEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "calochroa"
)
val catarinensisEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "catarinensis"
)
val tinctoriusEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "tinctorius"
)
val puiggariiEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "puiggarii"
)
val rubropunctatissimaEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "rubropunctatissima"
)
val terrestrisEpithet = FungusSpecieEpithet(
    id = Uuid.random(),
    name = "terrestris"
)


val fungusSpecieEpithetListData = listOf(
    spEpithet,
    sp1Epithet,
    sp2Epithet,
    sp3Epithet,
    sp4Epithet,
    sp5Epithet,
    sp6Epithet,
    sp7Epithet,
    viscidoluteaEpithet,
    festivusEpithet,
    quyanensisEpithet,
    calochroaEpithet,
    catarinensisEpithet,
    tinctoriusEpithet,
    puiggariiEpithet,
    rubropunctatissimaEpithet,
    terrestrisEpithet
)

val amanitaCfCalochroaSpecie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = calochroaEpithet,
)
val amanitaSp1Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp1Epithet,
)
val amanitaSp2Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp2Epithet,
)
val amanitaSp3Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp3Epithet,
)
val amanitaSp4Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp4Epithet,
)
val amanitaSp5Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp5Epithet,
)
val amanitaSp6Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp6Epithet,
)
val amanitaSp7Specie = FungusSpecie(
    Uuid.random(),
    genus = amanitaGenus,
    epithet = sp7Epithet,
)
val amanitaViscidoluteaSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = amanitaGenus,
    epithet = viscidoluteaEpithet
)
val austroboletusFestivusSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = austroboletusGenus,
    epithet = festivusEpithet
)
val brasilioporusSpSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = brasilioporusGenus,
    epithet = spEpithet
)
val cantharellusQuyanensisSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = cantharellusGenus,
    epithet = quyanensisEpithet,
)
val cantharellusSpSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = cantharellusGenus,
    epithet = spEpithet,
)
val thelephoraTerrestrisSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = thelephoraGenus,
    epithet = terrestrisEpithet,
)
val thelephoraSp1Specie = FungusSpecie(
    id = Uuid.random(),
    genus = thelephoraGenus,
    epithet = sp1Epithet,
)
val thelephoraSp2Specie = FungusSpecie(
    id = Uuid.random(),
    genus = thelephoraGenus,
    epithet = sp2Epithet,
)
val thelephoraSp3Specie = FungusSpecie(
    id = Uuid.random(),
    genus = thelephoraGenus,
    epithet = sp3Epithet,
)
val inocybeSpSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = inocybeGenus,
    epithet = spEpithet
)
val clavulinaSpSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = clavulinaGenus,
    epithet = spEpithet
)
val cortinariusSpSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = cortinariusGenus,
    epithet = spEpithet
)
val inocybeSp1Specie = FungusSpecie(
    id = Uuid.random(),
    genus = inocybeGenus,
    epithet = sp1Epithet
)
val inocybeSp2Specie = FungusSpecie(
    id = Uuid.random(),
    genus = inocybeGenus,
    epithet = sp2Epithet
)
val inocybeSp3Specie = FungusSpecie(
    id = Uuid.random(),
    genus = inocybeGenus,
    epithet = sp3Epithet
)
val lactifluusCatarinensisSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = lactifluusGenus,
    epithet = catarinensisEpithet
)
val pisolithusTinctoriusSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = pisolithusGenus,
    epithet = tinctoriusEpithet
)
val russulaPuiggariiSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = russulaGenus,
    epithet = puiggariiEpithet
)
val russulaRubropunctatissimaSpecie = FungusSpecie(
    id = Uuid.random(),
    genus = russulaGenus,
    epithet = rubropunctatissimaEpithet
)
val russulaSp1Specie = FungusSpecie(
    id = Uuid.random(),
    genus = russulaGenus,
    epithet = sp1Epithet
)
val russulaSp2Specie = FungusSpecie(
    id = Uuid.random(),
    genus = russulaGenus,
    epithet = sp2Epithet
)
val russulaSp3Specie = FungusSpecie(
    id = Uuid.random(),
    genus = russulaGenus,
    epithet = sp3Epithet
)

val fungusSpeciesData = listOf(
    amanitaCfCalochroaSpecie,
    amanitaSp1Specie,
    amanitaSp2Specie,
    amanitaSp3Specie,
    amanitaSp4Specie,
    amanitaSp5Specie,
    amanitaSp6Specie,
    amanitaSp7Specie,
    amanitaViscidoluteaSpecie,
    austroboletusFestivusSpecie,
    brasilioporusSpSpecie,
    cantharellusQuyanensisSpecie,
    cantharellusSpSpecie,
    thelephoraTerrestrisSpecie,
    thelephoraSp1Specie,
    thelephoraSp2Specie,
    thelephoraSp3Specie,
    inocybeSpSpecie,
    clavulinaSpSpecie,
    cortinariusSpSpecie,
    inocybeSp1Specie,
    inocybeSp2Specie,
    inocybeSp3Specie,
    lactifluusCatarinensisSpecie,
    pisolithusTinctoriusSpecie,
    russulaPuiggariiSpecie,
    russulaRubropunctatissimaSpecie,
    russulaSp1Specie,
    russulaSp2Specie,
    russulaSp3Specie
)

val thelephoraceaeSpFamily = FungusFamily(
    id = Uuid.random(),
    name = "Thelephoraceae sp.",
)
val thelephoraceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Thelephoraceae"
)
val amanitaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Amanitaceae"
)
val boletaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Boletaceae"
)
val cantharellaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Cantharellaceae"
)
val hydnaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Hydnaceae"
)
val cortinariaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Cortinariaceae"
)
val inocybaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Inocybaceae"
)
val russulaceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Russulaceae"
)
val sclerodermataceaeFamily = FungusFamily(
    id = Uuid.random(),
    name = "Sclerodermataceae"
)

val fungusFamiliesData = listOf(
    thelephoraceaeSpFamily,
    thelephoraceaeFamily,
    amanitaceaeFamily,
    boletaceaeFamily,
    cantharellaceaeFamily,
    hydnaceaeFamily,
    cortinariaceaeFamily,
    inocybaceaeFamily,
    russulaceaeFamily,
    sclerodermataceaeFamily,
)

val amanitaCfCalochroaAmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaCfCalochroaSpecie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-cf- calochroa.png",
        legend = Res.string.fungus_legend_amanita_cf_calochroa,
        author = "Juli Simon Cardoso"
    )
)
val amanitaViscidoluteaAmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaViscidoluteaSpecie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-viscidolutea.png",
        legend = Res.string.fungus_legend_amanita_viscidolutea,
        author = "M. A. Neves"
    )
)
val amanitaSp1AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp1Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-1.png",
        legend = Res.string.fungus_legend_amanita_sp1,
        author = "M. C. Slodkowski"
    )
)
val amanitaSp2AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp2Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-2.png",
        legend = Res.string.fungus_legend_amanita_sp2,
        author = "M. C. Slodkowski"
    )
)
val amanitaSp3AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp3Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-3.png",
        legend = Res.string.fungus_legend_amanita_sp3,
        author = "Juli Simon Cardoso"
    )
)
val amanitaSp4AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp4Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-4.png",
        legend = Res.string.fungus_legend_amanita_sp4,
        author = "Juli Simon Cardoso"
    )
)
val amanitaSp5AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp5Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-5.png",
        legend = Res.string.fungus_legend_amanita_sp5,
        author = "Juli Simon Cardoso"
    )
)
val amanitaSp6AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp6Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-6.png",
        legend = Res.string.fungus_legend_amanita_sp6,
        author = "Juli Simon Cardoso"
    )
)
val amanitaSp7AmanitaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = amanitaSp7Specie,
    family = amanitaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/amanita-sp-7.png",
        legend = Res.string.fungus_legend_amanita_sp7,
        author = "Juli Simon Cardoso"
    )
)
val austroboletusFestivusBoletaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = austroboletusFestivusSpecie,
    family = boletaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/austroboletus-festivus.png",
        legend = Res.string.fungus_legend_austroboletus_festivus,
        author = "M. C. Slodkowski"
    )
)
val brasilioporusSpBoletaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = brasilioporusSpSpecie,
    family = boletaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/brasilioporus-sp.png",
        legend = Res.string.fungus_legend_brasilioporus_sp,
        author = "Francisco Farroñay"
    )
)
val cantharellusQuyanensisCantharellaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = cantharellusQuyanensisSpecie,
    family = cantharellaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/cantharellus-guyanensis.png",
        legend = Res.string.fungus_legend_cantharellus_guyanensis,
        author = "Juli Simon Cardoso"
    )
)
val cantharellusSpCantharellaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = cantharellusSpSpecie,
    family = cantharellaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/cantharellus-sp.png",
        legend = Res.string.fungus_legend_cantharellus_sp,
        author = "M. A. Neves"
    )
)
val clavulinaSpHydnaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = clavulinaSpSpecie,
    family = hydnaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/clavulina-sp.png",
        legend = Res.string.fungus_legend_clavulina_sp,
        author = "M. C. Slodkowski"
    )
)
val cortinariusSpCortinariaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = cortinariusSpSpecie,
    family = cortinariaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/cortinarius-sp.png",
        legend = Res.string.fungus_legend_cortinarius_sp,
        author = "Juli Simon Cardoso"
    )
)
val inocybeSp1InocybaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = inocybeSp1Specie,
    family = inocybaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/inocybe-sp-1.png",
        legend = Res.string.fungus_legend_inocybe_sp1,
        author = "M. C. Slodkowski"
    )
)
val inocybeSp2InocybaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = inocybeSp2Specie,
    family = inocybaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/inocybe-sp-2.png",
        legend = Res.string.fungus_legend_inocybe_sp2,
        author = "Juli Simon Cardoso"
    )
)
val inocybeSp3InocybaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = inocybeSp3Specie,
    family = inocybaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/inocybe-sp-3.png",
        legend = Res.string.fungus_legend_inocybe_sp3,
        author = "Juli Simon Cardoso"
    )
)
val lactifluusCatarinensisRussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = lactifluusCatarinensisSpecie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/lactifluus-catarinensis.png",
        legend = Res.string.fungus_legend_lactifluus_catarinensis,
        author = "M. A. Neves"
    )
)
val pisolithusTinctoriusSclerodermataceaeFungus = Fungus(
    id = Uuid.random(),
    specie = pisolithusTinctoriusSpecie,
    family = sclerodermataceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/pisolithus-tinctorius.png",
        legend = Res.string.fungus_legend_pisolithus_tinctorius,
        author = "M. A. Neves"
    )
)
val russulaPuiggariiRussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = russulaPuiggariiSpecie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/russula-puiggarii.png",
        legend = Res.string.fungus_legend_russula_puiggarii,
        author = "M. C. Slodkowski"
    )
)
val russulaRubropunctatissimaRussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = russulaRubropunctatissimaSpecie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/russula-rubropunctatissima.png",
        legend = Res.string.fungus_legend_russula_rubropunctatissima,
        author = "M. A. Neves"
    )
)
val russulaSp1RussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = russulaSp1Specie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/russula-sp-1.png",
        legend = Res.string.fungus_legend_russula_sp1,
        author = "Juli Simon Cardoso"
    )
)
val russulaSp2RussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = russulaSp2Specie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/russula-sp-2.png",
        legend = Res.string.fungus_legend_russula_sp2,
        author = "Juli Simon Cardoso"
    )
)
val russulaSp3RussulaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = russulaSp3Specie,
    family = russulaceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/russula-sp-3.png",
        legend = Res.string.fungus_legend_russula_sp3,
        author = "Juli Simon Cardoso"
    )
)
val thelephoraTerrestrisThelephoraceaeFungus = Fungus(
    id = Uuid.random(),
    specie = thelephoraTerrestrisSpecie,
    family = thelephoraceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/thelephora-terrestris.png",
        legend = Res.string.fungus_legend_thelephora_terrestris,
        author = "J. P. Ernzen"
    )
)
val thelephoraSp1ThelephoraceaeFungus = Fungus(
    id = Uuid.random(),
    specie = thelephoraSp1Specie,
    family = thelephoraceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/thelephora-sp-1.png",
        legend = Res.string.fungus_legend_thelephora_sp1,
        author = "J. P. Ernzen"
    )
)
val thelephoraSp2ThelephoraceaeFungus = Fungus(
    id = Uuid.random(),
    specie = thelephoraSp2Specie,
    family = thelephoraceaeFamily,
    image = DataImage(
        path = "files/atlas/fungi/thelephora-sp-2.png",
        legend = Res.string.fungus_legend_thelephora_sp2,
        author = "J. P. Ernzen"
    )
)
val thelephoraSp3ThelephoraceaeFungus = Fungus(
    id = Uuid.random(),
    specie = thelephoraSp3Specie,
    family = thelephoraceaeFamily,
    image = null,
)
val thelephoraceaeSpFungus = Fungus(
    id = Uuid.random(),
    specie = null,
    family = thelephoraceaeSpFamily,
    image = null,
)
val inocybeSpInocybaceaeFungus = Fungus(
    id = Uuid.random(),
    specie = inocybeSpSpecie,
    family = inocybaceaeFamily,
    image = null,
)

val fungiData = listOf(
    amanitaCfCalochroaAmanitaceaeFungus,
    amanitaViscidoluteaAmanitaceaeFungus,
    amanitaSp1AmanitaceaeFungus,
    amanitaSp2AmanitaceaeFungus,
    amanitaSp3AmanitaceaeFungus,
    amanitaSp4AmanitaceaeFungus,
    amanitaSp5AmanitaceaeFungus,
    amanitaSp6AmanitaceaeFungus,
    amanitaSp7AmanitaceaeFungus,
    austroboletusFestivusBoletaceaeFungus,
    brasilioporusSpBoletaceaeFungus,
    cantharellusQuyanensisCantharellaceaeFungus,
    cantharellusSpCantharellaceaeFungus,
    clavulinaSpHydnaceaeFungus,
    cortinariusSpCortinariaceaeFungus,
    inocybeSp1InocybaceaeFungus,
    inocybeSp2InocybaceaeFungus,
    inocybeSp3InocybaceaeFungus,
    lactifluusCatarinensisRussulaceaeFungus,
    pisolithusTinctoriusSclerodermataceaeFungus,
    russulaPuiggariiRussulaceaeFungus,
    russulaRubropunctatissimaRussulaceaeFungus,
    russulaSp1RussulaceaeFungus,
    russulaSp2RussulaceaeFungus,
    russulaSp3RussulaceaeFungus,
    thelephoraTerrestrisThelephoraceaeFungus,
    thelephoraSp1ThelephoraceaeFungus,
    thelephoraSp2ThelephoraceaeFungus,
)

val guapiraGenus = HostSpecieGenus(
    id = Uuid.random(),
    name = "Guapira"
)

val hostSpecieGenusListData = listOf(
    guapiraGenus
)

val oppositaEpithet = HostSpecieEpithet(
    id = Uuid.random(),
    name = "opposita"
)

val hostSpecieEpithetListData = listOf(
    oppositaEpithet
)

val guapiraOppositaSpecie = HostSpecie(
    id = Uuid.random(),
    genus = guapiraGenus,
    epithet = oppositaEpithet
)

val hostSpeciesData = listOf(
    guapiraOppositaSpecie
)

val nyctaginaceaeFamily = HostFamily(
    id = Uuid.random(),
    name = "Nyctaginaceae"
)

val hostFamiliesData = listOf(
    nyctaginaceaeFamily
)

val guapiraOppositaNyctaginaceaeHost = Host(
    id = Uuid.random(),
    specie = guapiraOppositaSpecie,
    family = nyctaginaceaeFamily,
    image = null,
)

val hostsData = listOf(
    guapiraOppositaNyctaginaceaeHost,
)

val ectomycorrhizaeData = listOf(
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = clavulinaSpHydnaceaeFungus,
        host = guapiraOppositaNyctaginaceaeHost,
        type = guapirioidType,
        colorDescription = "light brown to yellowish-brown",
        hartigNet = HartigNet.ABSENT,
        mantleThickness = "25 µm",
        hyphaeMantle = HyphaeMantle.CLAMPLESS,
        outerMantleLayer = OuterMantleLayer.PLECTENCHYMATOUS,
        hyphalStrands = HyphalStrands.PRESENT,
        ecosystem = "Restinga, Mata Atlântica, Brazil",
        genBankAccessionNumbers = listOf("PX105292", "PX105293"),
        references = listOf("Slodkowski et al., unpublished data"),
        morphologicalCharacters = "Ectomycorrhizal system is simple, sometimes irregularly pinnate, with no branching at the root tips. Some roots are not completely covered by the mantle. Colonized roots measure 1.5–5.5 mm in length and 0.1–0.2 mm in thickness. The mantle is 25 μm thick, mantle surface smooth, light brown to yellowish-brown (2.5Y 8/10; 2.5Y 8/8) and parts brown (5YR 1/1), with tips that are straight or occasionally curved (Fig. 1. A-C).",
        mantleAnatomicalCharacters = "Outer mantle layer plectenchymatous in plane view. Hyphae 3.0–5.0(–7.0) μm thick, hyaline, smooth, thin-walled, agglutinated; clampless (Fig. 1. C). Emanating hyphae hyaline, thin-walled, 3.0–5.0 µm in diameter, clamped. Hyphal strands undifferentiated with smooth margins (Fig. 1. D). Cystidia not observed.",
        images = listOf(
            DataImage(
                path = "files/atlas/ectomycorrhiza/clavulina/clavulina_A.png",
                legend = Res.string.ecm_legend_clavulina_a,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/clavulina/clavulina_B.png",
                legend = Res.string.ecm_legend_clavulina_b,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/clavulina/clavulina_C.png",
                legend = Res.string.ecm_legend_clavulina_c,
                author = "L. Herberts-Sousa",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/clavulina/clavulina_D.png",
                legend = Res.string.ecm_legend_clavulina_d,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/clavulina/clavulina_E.png",
                legend = Res.string.ecm_legend_clavulina_e,
                author = "M. C. Slodkowski",
            ),
        )
    ),
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = inocybeSpInocybaceaeFungus,
        host = guapiraOppositaNyctaginaceaeHost,
        type = guapirioidType,
        colorDescription = "yellowish-white with tips greyish-purple",
        hartigNet = HartigNet.ABSENT,
        mantleThickness = "25–50 μm",
        hyphaeMantle = HyphaeMantle.CLAMPLESS,
        outerMantleLayer = OuterMantleLayer.PLECTENCHYMATOUS,
        hyphalStrands = HyphalStrands.ABSENT,
        ecosystem = "Restinga, Mata Atlântica, Brazil",
        genBankAccessionNumbers = listOf("PX097979", "PX097982"),
        references = listOf("Slodkowski et al., unpublished data"),
        morphologicalCharacters = "Ectomycorrhizal system is irregularly pinnate, sometimes dichotomous, measuring approximately 15 mm in length and 0.1–0.3 mm in thickness. The mantle is 25–50 μm thick, mantle surface smooth, yellowish-white (10YR 9/2) with tips greyish-purple (2.5P 9/4), tips are straight, curved, or occasionally tortuous (Fig.2 A-C). ",
        mantleAnatomicalCharacters = "Outer mantle layer plectenchymatous, irregular hyphae growing over the mantle surface. Hyphae 3.0–5.0 μm thick, hyaline, smooth, thin-walled, clampless (Fig. 2. E). Emanating hyphae hyaline, 2.0–4.0 µm in diameter, ramified; clampless. Hyphal strands absent. Cystidia not observed.",
        images = listOf(
            DataImage(
                path = "files/atlas/ectomycorrhiza/inocybe/inocybe_A.png",
                legend = Res.string.ecm_legend_inocybe_a,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/inocybe/inocybe_B.png",
                legend = Res.string.ecm_legend_inocybe_b,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/inocybe/inocybe_C.png",
                legend = Res.string.ecm_legend_inocybe_c,
                author = "M. C. Slodkowski",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/inocybe/inocybe_D.png",
                legend = Res.string.ecm_legend_inocybe_d,
                author = "L. Herberts-Sousa",
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/inocybe/inocybe_E.png",
                legend = Res.string.ecm_legend_inocybe_e,
                author = "M. C. Slodkowski",
            ),
        )
    ),
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = thelephoraceaeSpFungus,
        host = guapiraOppositaNyctaginaceaeHost,
        type = guapirioidType,
        colorDescription = "light brown or yellowish-brown",
        hartigNet = HartigNet.ABSENT,
        mantleThickness = "25–50 μm",
        hyphaeMantle = HyphaeMantle.CLAMPLESS,
        outerMantleLayer = OuterMantleLayer.PLECTENCHYMATOUS,
        hyphalStrands = HyphalStrands.ABSENT,
        ecosystem = "Restinga, Mata Atlântica, Brazil",
        genBankAccessionNumbers = listOf(
            "PX097976",
            "PX097977",
            "PX097978",
            "PX097980",
            "PX097981"
        ),
        references = listOf("Slodkowski et al., unpublished data"),
        morphologicalCharacters = "Ectomycorrhizal system is irregularly pinnate, with no branching at the root tips, and colonization occurs in secondary and tertiary roots. Colonized roots measure 0.5–5.7 mm in length and 0.1–0.3 mm in thickness. The mantle is 25–50 μm thick, mantle surface smooth, light brown (7.5YR 3/6) or yellowish-brown (2.5Y 8/8), and tips straight or slightly curved (Fig. 3. A-D).",
        mantleAnatomicalCharacters = "Outer mantle layer plectenchymatous in plane view. Hyphae 3.0–6.0 μm thick, orangish-brown (7.5Y 6/6), smooth, thin-walled, agglutinated; clampless (Fig. 3. E). Emanating hyphae hyaline, clamped, thin-walled, 3.0–5.0 µm in diameter, clamped. Hyphal strands absent. Cystidia not observed.",
        images = listOf(
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephoraceae/thelephoraceae_A.png",
                legend = Res.string.ecm_legend_thelephoraceae_sp_a,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephoraceae/thelephoraceae_B.png",
                legend = Res.string.ecm_legend_thelephoraceae_sp_b,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephoraceae/thelephoraceae_C.png",
                legend = Res.string.ecm_legend_thelephoraceae_sp_c,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephoraceae/thelephoraceae_D.png",
                legend = Res.string.ecm_legend_thelephoraceae_sp_d,
                author = "L. Herberts-Sousa"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephoraceae/thelephoraceae_E.png",
                legend = Res.string.ecm_legend_thelephoraceae_sp_e,
                author = "M. C. Slodkowski"
            ),
        )
    ),
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = thelephoraSp1ThelephoraceaeFungus,
        host = guapiraOppositaNyctaginaceaeHost,
        type = guapirioidType,
        colorDescription = "dark brown",
        hartigNet = HartigNet.ABSENT,
        mantleThickness = "10–25 μm",
        hyphaeMantle = HyphaeMantle.CLAMPLESS,
        outerMantleLayer = OuterMantleLayer.TRANSITIONAL,
        hyphalStrands = HyphalStrands.PRESENT,
        ecosystem = "Restinga, Mata Atlântica, Brazil",
        genBankAccessionNumbers = listOf("PX097971", "PX097972", "PX097973 "),
        references = listOf("Slodkowski et al., unpublished data"),
        morphologicalCharacters = "Ectomycorrhizal system is simple and monopodial-pinnate, occasionally dichotomous. Colonized tertiary roots measure 1–7.5 mm in length and 0.1–0.3 mm in thickness. Colonization of quaternary roots was also observed, with spacing of 1.8–2.5 mm and thickness of approximately 0.4 mm. The mantle surface is 10–25 μm thick, mantle surface smooth, dark brown (2.5YR 1/1) at the base and median region, becoming brown (2.5YR 1/2) toward the slightly curved, unbranched tips (Fig. 4. A-C).",
        mantleAnatomicalCharacters = "Outer mantle layer transitional type between plectenchymatous and pseudoparenchymatous in plane view. Hyphae irregularly shaped, yellowish-brown (2.5Y 5/6), 5,0–7,0 μm in diameter, slightly thin-walled, smooth (Fig. 4. D). Emanating hyphae 3.0–5.0 μm thick, brown, thick-walled (1.0 μm thick), clamped. Hyphal strands can be present or be less evident, formed by irregular, wavy hyphae of the uniform diameter, clamped (Fig. 4. E). Cystidia not observed.",
        images = listOf(
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-1/thelephora-sp-1_A.png",
                legend = Res.string.ecm_legend_thelephora_sp1_a,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-1/thelephora-sp-1_B.png",
                legend = Res.string.ecm_legend_thelephora_sp1_b,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-1/thelephora-sp-1_C.png",
                legend = Res.string.ecm_legend_thelephora_sp1_c,
                author = "L. Herberts-Sousa"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-1/thelephora-sp-1_D.png",
                legend = Res.string.ecm_legend_thelephora_sp1_d,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-1/thelephora-sp-1_E.png",
                legend = Res.string.ecm_legend_thelephora_sp1_e,
                author = "M. C. Slodkowski"
            ),
        )
    ),
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = thelephoraSp2ThelephoraceaeFungus,
        host = guapiraOppositaNyctaginaceaeHost,
        type = guapirioidType,
        colorDescription = "brown to light brown at the tips",
        hartigNet = HartigNet.ABSENT,
        mantleThickness = "20–25 μm",
        hyphaeMantle = HyphaeMantle.CLAMPLESS,
        outerMantleLayer = OuterMantleLayer.TRANSITIONAL,
        hyphalStrands = HyphalStrands.PRESENT,
        ecosystem = "Restinga, Mata Atlântica, Brazil",
        genBankAccessionNumbers = listOf("PX097974", "PX097975"),
        references = listOf("Slodkowski et al., unpublished data"),
        morphologicalCharacters = "Ectomycorrhizal system is irregularly pinnate, with no branching at the root tips, measuring 0.7–11.8 mm in length and 0.1–0.3 mm in thickness. The mantle is 20–25 μm thick, mantle surface smooth, brown (5YR 1/1) to light brown at the tips (7.5YR 3/6), and dark brown (7.5YR 1/1) above the tip, the tips are straight, tortuous, or curved (Fig. 5. A-C).",
        mantleAnatomicalCharacters = "Outer mantle layer transitional type between plectenchymatous and pseudoparenchymatous in plane view. Hyphae 5.0–8.0 μm thick, brownish (10YR 5/6), smooth, thin-walled, agglutinated; clampless. Emanating hyphae brownish, thick-walled (1.0 μm thick), (2.0–)3.0–4.0 µm in diameter, ramified; sometimes filled with homogeneous brown content; clamped (Fig. 5. D). Hyphal strands densely interwoven and aggregated, formed by brown hyphae: one central hyphae, 7.0–10.0 μm in diameter, thick-walled (1 μm thick), clamped; peripheral brown hyphae, 3.0–4.0 μm in diameter, slightly thickened walls, tortuous, densely woven, branched, clamped (Fig. 5. E). Cystidia not observed.",
        images = listOf(
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-2/thelephora-sp-2_A.png",
                legend = Res.string.ecm_legend_thelephora_sp2_a,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-2/thelephora-sp-2_B.png",
                legend = Res.string.ecm_legend_thelephora_sp2_b,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-2/thelephora-sp-2_C.png",
                legend = Res.string.ecm_legend_thelephora_sp2_c,
                author = "L. Herberts-Sousa"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-2/thelephora-sp-2_D.png",
                legend = Res.string.ecm_legend_thelephora_sp2_d,
                author = "M. C. Slodkowski"
            ),
            DataImage(
                path = "files/atlas/ectomycorrhiza/thelephora-sp-2/thelephora-sp-2_E.png",
                legend = Res.string.ecm_legend_thelephora_sp2_e,
                author = "M. C. Slodkowski"
            ),
        )
    ),
//    Ectomycorrhiza(
//        id = Uuid.random(),
//        fungus = thelephoraSp3Thelephoraceae,
//        host = guapiraOppositaNyctaginaceae,
//        type = guapirioid,
//        colorDescription = "reddish-brown",
//        hartigNet = HartigNet.ABSENT,
//        mantleThickness = "20–25 μm",
//        hyphaeMantle = HyphaeMantle.CLAMPLESS,
//        outerMantleLayer = OuterMantleLayer.TRANSITIONAL,
//        hyphalStrands = HyphalStrands.PRESENT,
//        ecosystem = "Restinga, Mata Atlântica, Brazil",
//        genBankAccessionNumbers = listOf(),
//        references = listOf("Slodkowski et al., unpublished data"),
//        morphologicalCharacters = "Ectomycorrhizal system is irregularly pinnate, with no branching at the root tips, measuring 0.7–11.8 mm in length and 0.1–0.3 mm in thickness. The mantle is 20–25 μm thick, mantle surface smooth, brown (5YR 1Secondary root branching with evident ECMg and root hairs, reddish-brown (2.5YR 1/2) or light brown in color. Colonization of secondary, tertiary, and quaternary roots, irregular pinnate ectomycorrhizal system, without branching at the root tips. Mantle with irregular surface, straight, tortuous, or curved tips, dark brown in color (Fig. 6. A-D). ",
//        mantleAnatomicalCharacters = "",
//        images = listOf(
//            DataImage(
//                path = "files/atlas/ectomycorrhiza/thelephora-sp-3/thelephora-sp-3_A.png",
//                legend = "Example legend"
//            ),
//            DataImage(
//                path = "files/atlas/ectomycorrhiza/thelephora-sp-3/thelephora-sp-3_B.png",
//                legend = "Example legend"
//            ),
//            DataImage(
//                path = "files/atlas/ectomycorrhiza/thelephora-sp-3/thelephora-sp-3_C.png",
//                legend = "Example legend"
//            ),
//            DataImage(
//                path = "files/atlas/ectomycorrhiza/thelephora-sp-3/thelephora-sp-3_D.png",
//                legend = "Example legend"
//            ),
//            DataImage(
//                path = "files/atlas/ectomycorrhiza/thelephora-sp-3/thelephora-sp-3_E.png",
//                legend = "Example legend"
//            ),
//        )
//    ),
)

val glossaryData = listOf(
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.agglutinated_term,
        definition = Res.string.agglutinated_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.clamp_or_clamp_connection_term,
        definition = Res.string.clamp_or_clamp_connection_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.cystidia_term,
        definition = Res.string.cystidia_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.cortex_term,
        definition = Res.string.cortex_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.dichotomous_ectomycorrhizae_term,
        definition = Res.string.dichotomous_ectomycorrhizae_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.emanating_hyphae_term,
        definition = Res.string.emanating_hyphae_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.epidermis_term,
        definition = Res.string.epidermis_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.gelatinous_hyphae_term,
        definition = Res.string.gelatinous_hyphae_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.hartig_net_term,
        definition = Res.string.hartig_net_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.hyphal_strands_term,
        definition = Res.string.hyphal_strands_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.transverse_section_term,
        definition = Res.string.transverse_section_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.mantle_mycorrhizal_mantle_term,
        definition = Res.string.mantle_mycorrhizal_mantle_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.matrix_matrix_gelatinous_term,
        definition = Res.string.matrix_matrix_gelatinous_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.mycorrhizal_system_term,
        definition = Res.string.mycorrhizal_system_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.mycorrhiza_mycorrhizal_tip_term,
        definition = Res.string.mycorrhiza_mycorrhizal_tip_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.parenchyma_term,
        definition = Res.string.parenchyma_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.plan_view_term,
        definition = Res.string.plan_view_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.plectenchymatous_term,
        definition = Res.string.plectenchymatous_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.pseudoparenchymatous_term,
        definition = Res.string.pseudoparenchymatous_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.root_hair_term,
        definition = Res.string.root_hair_definition
    ),
    GlossaryEntry(
        id = Uuid.random(),
        term = Res.string.outer_surface_of_mantle_term,
        definition = Res.string.outer_surface_of_mantle_definition
    ),
)
