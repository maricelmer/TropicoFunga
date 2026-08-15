package br.com.monolit.tropicofunga.features

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaeViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.impl.EctomycorrhizaeViewModelImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val featuresModule = module {
    viewModel<EctomycorrhizaeViewModel> {
        EctomycorrhizaeViewModelImpl(repository = get())
    }
}