package br.com.monolit.tropicofunga.repository.impl

import br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.data.fungus.Fungus
import br.com.monolit.tropicofunga.data.glossary.GlossaryEntry
import br.com.monolit.tropicofunga.data.host.Host
import br.com.monolit.tropicofunga.repository.AppRepository
import br.com.monolit.tropicofunga.repository.impl.staticData.ectomycorrhizaeData
import br.com.monolit.tropicofunga.repository.impl.staticData.fungiData
import br.com.monolit.tropicofunga.repository.impl.staticData.glossaryData
import br.com.monolit.tropicofunga.repository.impl.staticData.hostsData
import kotlin.uuid.Uuid

class StaticDataAppRepositoryImpl : AppRepository {
    override suspend fun loadEctomycorrhizae(): Result<List<Ectomycorrhiza>> {
        return Result.success(ectomycorrhizaeData)
    }

    override suspend fun loadEctomycorrhiza(id: Uuid): Result<Ectomycorrhiza?> {
        val ectomycorrhiza = ectomycorrhizaeData.firstOrNull { it.id == id }
        return Result.success(ectomycorrhiza)
    }

    override suspend fun loadFungi(): Result<List<Fungus>> {
        return Result.success(fungiData)
    }

    override suspend fun loadHosts(): Result<List<Host>> {
        return Result.success(hostsData)
    }

    override suspend fun loadGlossary(): Result<List<GlossaryEntry>> {
        return Result.success(glossaryData)
    }
}