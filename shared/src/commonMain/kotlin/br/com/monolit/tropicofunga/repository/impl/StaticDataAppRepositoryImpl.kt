package br.com.monolit.tropicofunga.repository.impl

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.Ectomycorrhiza
import br.com.monolit.tropicofunga.repository.AppRepository
import br.com.monolit.tropicofunga.repository.impl.staticData.ectomycorrhizaeData
import kotlin.uuid.Uuid

class StaticDataAppRepositoryImpl : AppRepository {
    override suspend fun loadEctomycorrhizae(): Result<List<Ectomycorrhiza>> {
        return try {
            Result.success(ectomycorrhizaeData)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun loadEctomycorrhiza(id: Uuid): Result<Ectomycorrhiza?> {
        return try {
            val ectomycorrhiza = ectomycorrhizaeData.firstOrNull { it.id == id }
            Result.success(ectomycorrhiza)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}