package com.luan.teste.data.remote.repositories.datasource

import com.luan.teste.data.remote.repositories.model.toRepo
import com.luan.teste.data.remote.repositories.service.RepositoriesService
import com.luan.teste.data.remote.utils.resultFlow
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import com.luan.teste.data.repository.repositories.model.RepositoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response

class RepositoriesDataSourceImpl(
    private val service: RepositoriesService
) : RepositoriesDataSource {
    override suspend fun getRepositories(): Flow<List<RepositoryData>> = flow {
        service.getRepositories().resultFlow().collect {
            emit(it.items.map { list -> list.toRepo() })
        }
    }
}