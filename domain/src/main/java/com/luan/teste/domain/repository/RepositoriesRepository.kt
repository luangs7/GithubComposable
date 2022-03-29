package com.luan.teste.domain.repository

import com.luan.teste.common.base.ApiResult
import com.luan.teste.domain.model.repositories.Repository
import kotlinx.coroutines.flow.Flow

interface RepositoriesRepository {
    suspend fun getRepositories(): Flow<ApiResult<List<Repository>>>
}