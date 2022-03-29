package com.luan.teste.data.remote.repositories.datasource

import com.luan.teste.data.remote.repositories.model.toRepo
import com.luan.teste.data.remote.repositories.service.RepositoriesService
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import com.luan.teste.data.repository.repositories.model.RepositoryData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RepositoriesDataSourceImpl(
    private val service: RepositoriesService
) : RepositoriesDataSource {
    override suspend fun getRepositories(): Flow<List<RepositoryData>> = flow {
        val response = service.getRepositories()
        if (response.isSuccessful) {
            response.body()?.let { list ->
                emit(list.map { it.toRepo() })
            } ?: throw Exception()
        } else {
            throw Exception()
        }
    }
}