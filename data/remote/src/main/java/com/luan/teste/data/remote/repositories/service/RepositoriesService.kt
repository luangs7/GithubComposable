package com.luan.teste.data.remote.repositories.service

import com.luan.teste.data.remote.repositories.model.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface RepositoriesService {
    @GET("repositories")
    suspend fun getRepositories(): Response<List<RepositoryResponse>>
}