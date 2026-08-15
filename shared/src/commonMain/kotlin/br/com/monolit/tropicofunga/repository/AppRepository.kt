package br.com.monolit.tropicofunga.repository

import br.com.monolit.tropicofunga.features.atlasMycorrhizae.ectomycorrhizae.data.ectomycorrhiza.Ectomycorrhiza
import kotlin.uuid.Uuid

interface AppRepository {
    suspend fun loadEctomycorrhizae(): Result<List<Ectomycorrhiza>>

    suspend fun loadEctomycorrhiza(id: Uuid): Result<Ectomycorrhiza?>

}