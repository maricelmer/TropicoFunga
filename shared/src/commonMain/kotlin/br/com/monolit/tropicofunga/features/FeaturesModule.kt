package br.com.monolit.tropicofunga.features

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizaDetails.viewModel.impl.EctomycorrhizaDetailsViewModelImpl
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaDetailsViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.EctomycorrhizaeViewModel
import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.viewModel.impl.EctomycorrhizaeViewModelImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.uuid.Uuid

val featuresModule = module {
    viewModel<EctomycorrhizaeViewModel> {
        EctomycorrhizaeViewModelImpl(repository = get())
    }
    viewModel<EctomycorrhizaDetailsViewModel> { (id: Uuid) ->
        EctomycorrhizaDetailsViewModelImpl(id = id, repository = get())
    }
}