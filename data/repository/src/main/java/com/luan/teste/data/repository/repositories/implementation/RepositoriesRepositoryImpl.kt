package com.luan.teste.data.repository.repositories.implementation

import com.luan.teste.common.base.ApiResult
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import com.luan.teste.data.repository.repositories.model.toDomain
import com.luan.teste.domain.model.repositories.Repository
import com.luan.teste.domain.repository.RepositoriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class RepositoriesRepositoryImpl(
    private val repositoriesDataSource: RepositoriesDataSource
): RepositoriesRepository {
    override suspend fun getRepositories(): Flow<ApiResult<List<Repository>>> = flow {
        repositoriesDataSource.getRepositories()
            .catch { emit(ApiResult.Error<List<Repository>>(it)) }
            .collect { list ->
                val newList = list.map { it.toDomain() }
                emit(ApiResult.Success(newList))
            }
    }
}