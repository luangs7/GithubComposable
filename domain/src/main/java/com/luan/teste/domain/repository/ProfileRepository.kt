package com.luan.teste.domain.repository

import com.luan.teste.common.base.ApiResult
import com.luan.teste.domain.model.profile.User
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getUsers(): Flow<ApiResult<List<User>>>
    suspend fun getUserByUsername(username: String): Flow<ApiResult<User>>
}