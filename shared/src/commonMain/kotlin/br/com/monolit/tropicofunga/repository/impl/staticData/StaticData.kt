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
import tropicofunga.shared.generated.resources.emanating_hyphae_definition
import tropicofunga.shared.generated.resources.emanating_hyphae_term
import tropicofunga.shared.generated.resources.epidermis_definition
import tropicofunga.shared.generated.resources.epidermis_term
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
    "files/example/example.png",
    "Example legend"
)

val ectomycorrhizaTypesData = listOf(
    EctomycorrhizaType(
        id = Uuid.random(),
        name = "Guapirioid"
    )
)

val fungusSpecieGenusListData = listOf(
    FungusSpecieGenus(
        id = Uuid.random(),
        name = "Fungus Genus 1"
    ),
    FungusSpecieGenus(
        id = Uuid.random(),
        name = "Fungus Genus 2"
    )
)

val fungusSpecieEpithetListData = listOf(
    FungusSpecieEpithet(
        id = Uuid.random(),
        name = "Fungus Epithet 1"
    ),
    FungusSpecieEpithet(
        id = Uuid.random(),
        name = "Fungus Epithet 2"
    )
)

val fungusSpeciesData = listOf(
    FungusSpecie(
        id = Uuid.random(),
        genus = fungusSpecieGenusListData.random(),
        epithet = fungusSpecieEpithetListData.random()
    ),
    FungusSpecie(
        id = Uuid.random(),
        genus = fungusSpecieGenusListData.random(),
        epithet = fungusSpecieEpithetListData.random()
    )
)

val fungusFamiliesData = listOf(
    FungusFamily(
        id = Uuid.random(),
        name = "Fungus Family 1"
    ),
    FungusFamily(
        id = Uuid.random(),
        name = "Fungus Family 2"
    ),
)

val fungiData = listOf(
    Fungus(
        id = Uuid.random(),
        specie = fungusSpeciesData.random(),
        family = fungusFamiliesData.random(),
        image = examplePhoto,
    ),
    Fungus(
        id = Uuid.random(),
        specie = fungusSpeciesData.random(),
        family = fungusFamiliesData.random(),
        image = examplePhoto,
    ),
)

val hostSpecieGenusListData = listOf(
    HostSpecieGenus(
        id = Uuid.random(),
        name = "Host Genus 1"
    ),
    HostSpecieGenus(
        id = Uuid.random(),
        name = "Host Genus 2"
    )
)

val hostSpecieEpithetListData = listOf(
    HostSpecieEpithet(
        id = Uuid.random(),
        name = "Host Epithet 1"
    ),
    HostSpecieEpithet(
        id = Uuid.random(),
        name = "Host Epithet 2"
    )
)

val hostSpeciesData = listOf(
    HostSpecie(
        id = Uuid.random(),
        genus = hostSpecieGenusListData.random(),
        epithet = hostSpecieEpithetListData.random()
    ),
    HostSpecie(
        id = Uuid.random(),
        genus = hostSpecieGenusListData.random(),
        epithet = hostSpecieEpithetListData.random()
    )
)

val hostFamiliesData = listOf(
    HostFamily(
        id = Uuid.random(),
        name = "Host Family 1"
    ),
    HostFamily(
        id = Uuid.random(),
        name = "Host Family 2"
    )
)

val hostsData = listOf(
    Host(
        id = Uuid.random(),
        specie = hostSpeciesData.random(),
        family = hostFamiliesData.random(),
        image = examplePhoto
    ),
    Host(
        id = Uuid.random(),
        specie = hostSpeciesData.random(),
        family = hostFamiliesData.random(),
        image = examplePhoto
    )
)

val ectomycorrhizaeData = listOf(
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = fungiData.random(),
        host = hostsData.random(),
        type = ectomycorrhizaTypesData.random(),
        colorDescription = "",
        hartigNet = HartigNet.entries.random(),
        mantleThickness = "25 µm",
        hyphaeMantle = HyphaeMantle.entries.random(),
        outerMantleLayer = OuterMantleLayer.entries.random(),
        hyphalStrands = HyphalStrands.entries.random(),
        ecosystem = "Restinga, Brazil",
        genBankAccessionNumbers = listOf("AB123456", "CD789012"),
        references = listOf("Manuscript submitted for publication"),
        morphologicalCharacters = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vulputate, ex ornare accumsan imperdiet, turpis ex iaculis nibh, id tempus enim enim nec metus. Aliquam nec dui sed sem tristique elementum. Nam molestie tellus mi, et feugiat diam faucibus eu. Mauris imperdiet ac purus at iaculis. Aenean bibendum sapien nunc, ultrices porttitor tellus facilisis quis. Cras rhoncus viverra neque, in egestas massa tempus at. Mauris placerat purus a tempus congue. Nam tristique lacinia ex. Maecenas finibus convallis metus eget finibus. Ut gravida quam sed quam tempor venenatis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam convallis vitae nisi condimentum sagittis. Etiam quis lectus placerat, tristique nunc sed, elementum sapien.",
        mantleAnatomicalCharacters = "Proin rutrum, mauris non convallis efficitur, felis mauris ultricies velit, non malesuada quam risus in lorem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed tristique urna eget varius cursus. Nullam venenatis nunc ac quam ullamcorper facilisis. Nullam ultricies interdum lacus a congue. Praesent accumsan consectetur quam in blandit. Mauris imperdiet nibh auctor, hendrerit sapien at, porta mauris. Vivamus convallis nunc nec maximus porttitor. Mauris laoreet, orci ut consequat dignissim, arcu orci condimentum tortor, id condimentum metus nulla eu enim.",
        images = listOf(
            examplePhoto,
            examplePhoto,
            examplePhoto,
            examplePhoto
        )
    ),
    Ectomycorrhiza(
        id = Uuid.random(),
        fungus = fungiData.random(),
        host = hostsData.random(),
        type = ectomycorrhizaTypesData.random(),
        colorDescription = "",
        hartigNet = HartigNet.entries.random(),
        mantleThickness = "25 µm",
        hyphaeMantle = HyphaeMantle.entries.random(),
        outerMantleLayer = OuterMantleLayer.entries.random(),
        hyphalStrands = HyphalStrands.entries.random(),
        ecosystem = "Restinga, Brazil",
        genBankAccessionNumbers = listOf("AB123456", "CD789012"),
        references = listOf("Manuscript submitted for publication"),
        morphologicalCharacters = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vulputate, ex ornare accumsan imperdiet, turpis ex iaculis nibh, id tempus enim enim nec metus. Aliquam nec dui sed sem tristique elementum. Nam molestie tellus mi, et feugiat diam faucibus eu. Mauris imperdiet ac purus at iaculis. Aenean bibendum sapien nunc, ultrices porttitor tellus facilisis quis. Cras rhoncus viverra neque, in egestas massa tempus at. Mauris placerat purus a tempus congue. Nam tristique lacinia ex. Maecenas finibus convallis metus eget finibus. Ut gravida quam sed quam tempor venenatis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam convallis vitae nisi condimentum sagittis. Etiam quis lectus placerat, tristique nunc sed, elementum sapien.",
        mantleAnatomicalCharacters = "Proin rutrum, mauris non convallis efficitur, felis mauris ultricies velit, non malesuada quam risus in lorem. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed tristique urna eget varius cursus. Nullam venenatis nunc ac quam ullamcorper facilisis. Nullam ultricies interdum lacus a congue. Praesent accumsan consectetur quam in blandit. Mauris imperdiet nibh auctor, hendrerit sapien at, porta mauris. Vivamus convallis nunc nec maximus porttitor. Mauris laoreet, orci ut consequat dignissim, arcu orci condimentum tortor, id condimentum metus nulla eu enim.",
        images = listOf(
            examplePhoto,
            examplePhoto,
            examplePhoto,
            examplePhoto
        )
    )
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

