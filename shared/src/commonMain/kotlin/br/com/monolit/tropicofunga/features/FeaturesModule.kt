package br.com.monolit.tropicofunga.features

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featuresModule = module {

    viewModelOf(::EctomycorrhizaeViewModel)
}