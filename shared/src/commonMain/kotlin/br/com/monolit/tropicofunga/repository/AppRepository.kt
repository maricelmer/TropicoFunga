package br.com.monolit.tropicofunga.repository

import kotlin.uuid.Uuid

interface AppRepository {
    suspend fun loadEctomycorrhizae(): Result<List<br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza>>
    suspend fun loadEctomycorrhiza(id: Uuid): Result<br.com.monolit.tropicofunga.data.ectomycorrhiza.Ectomycorrhiza?>

    suspend fun loadFungi(): Result<List<br.com.monolit.tropicofunga.data.fungus.Fungus>>

    suspend fun loadHosts(): Result<List<br.com.monolit.tropicofunga.data.host.Host>>
}