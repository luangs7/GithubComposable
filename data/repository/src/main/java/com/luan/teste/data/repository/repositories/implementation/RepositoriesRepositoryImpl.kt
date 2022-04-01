package com.luan.teste.data.repository.repositories.implementation

import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.luan.teste.common.base.ApiResult
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import com.luan.teste.data.repository.repositories.model.toDomain
import com.luan.teste.domain.model.repositories.Repository
import com.luan.teste.domain.repository.RepositoriesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

class RepositoriesRepositoryImpl(
    private val repositoriesDataSource: RepositoriesDataSource,
    private val scope: CoroutineScope
): RepositoriesRepository {
    override suspend fun getRepositories(): Flow<ApiResult<PagingData<Repository>>> = flow {
        emit(ApiResult.Loading)
        repositoriesDataSource.getRepositories()
            .catch { emit(ApiResult.Error<PagingData<Repository>>(it)) }
            .cachedIn(scope)
            .collect { list ->
                val newList = list.map { it.toDomain() }
                emit(ApiResult.Success(newList))
            }
    }
}