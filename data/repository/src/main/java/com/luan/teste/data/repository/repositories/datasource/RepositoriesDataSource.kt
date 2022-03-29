package com.luan.teste.data.repository.repositories.datasource

import com.luan.teste.data.repository.repositories.model.RepositoryData
import kotlinx.coroutines.flow.Flow

interface RepositoriesDataSource {
    suspend fun getRepositories(): Flow<List<RepositoryData>>
}