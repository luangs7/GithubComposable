package com.luan.teste.data.remote.repositories.service

import com.luan.teste.data.remote.repositories.model.RepositoryResponse
import kotlinx.coroutines.delay
import retrofit2.Response
import retrofit2.http.GET

class RepositoriesServiceMock:RepositoriesService {
    override suspend fun getRepositories(): Response<List<RepositoryResponse>> {
        delay(3000)
        return Response.success(listOf())
    }
}