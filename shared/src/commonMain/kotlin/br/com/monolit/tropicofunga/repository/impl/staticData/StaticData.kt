package br.com.monolit.tropicofunga.repository.impl.staticData

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.DataImage
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.EctomycorrhizaType
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.HartigNet
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.HyphaeMantle
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.HyphalStrands
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.OuterMantleLayer
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.Fungus
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.FungusFamily
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.FungusSpecie
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.FungusSpecieEpithet
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.fungus.FungusSpecieGenus
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.Host
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.HostFamily
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.HostSpecie
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.HostSpecieEpithet
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.host.HostSpecieGenus
import kotlin.uuid.Uuid

val examplePhoto = DataImage("files/example/example.png", "Example legend")

val ectomycorrhizaTypesData = listOf(
    EctomycorrhizaType(id = Uuid.random(), name = "Guapirioid")
)

val fungusSpecieGenusListData = listOf(
    FungusSpecieGenus(id = Uuid.random(), name = "Fungus Genus 1"),
    FungusSpecieGenus(id = Uuid.random(), name = "Fungus Genus 2")
)

val fungusSpecieEpithetListData = listOf(
    FungusSpecieEpithet(id = Uuid.random(), name = "Fungus Epithet 1"),
    FungusSpecieEpithet(id = Uuid.random(), name = "Fungus Epithet 2")
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
    FungusFamily(id = Uuid.random(), name = "Fungus Family 1"),
    FungusFamily(id = Uuid.random(), name = "Fungus Family 2"),
)

val fungiData = listOf(
    Fungus(
        id = Uuid.random(),
        specie = fungusSpeciesData.random(),
        family = fungusFamiliesData.random()
    ),
    Fungus(
        id = Uuid.random(),
        specie = fungusSpeciesData.random(),
        family = fungusFamiliesData.random()
    ),
)

val hostSpecieGenusListData = listOf(
    HostSpecieGenus(id = Uuid.random(), name = "Host Genus 1"),
    HostSpecieGenus(id = Uuid.random(), name = "Host Genus 2")
)

val hostSpecieEpithetListData = listOf(
    HostSpecieEpithet(id = Uuid.random(), name = "Host Epithet 1"),
    HostSpecieEpithet(id = Uuid.random(), name = "Host Epithet 2")
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
    HostFamily(id = Uuid.random(), name = "Host Family 1"),
    HostFamily(id = Uuid.random(), name = "Host Family 2")
)

val hostsData = listOf(
    Host(id = Uuid.random(), specie = hostSpeciesData.random(), family = hostFamiliesData.random()),
    Host(id = Uuid.random(), specie = hostSpeciesData.random(), family = hostFamiliesData.random())
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
        photos = listOf(
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
        photos = listOf(
            examplePhoto,
            examplePhoto,
            examplePhoto,
            examplePhoto
        )
    )
)

