package com.luan.teste.data.remote.repositories.service

import com.luan.teste.data.remote.repositories.model.RepositoryResponse
import com.luan.teste.data.remote.repositories.model.RepositorySearchResponse
import retrofit2.Response
import retrofit2.http.GET

interface RepositoriesService {
    @GET("search/repositories?q=kotlin")
    suspend fun getRepositories(): Response<RepositorySearchResponse>
}