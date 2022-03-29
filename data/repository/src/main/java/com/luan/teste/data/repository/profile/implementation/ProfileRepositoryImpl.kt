package com.luan.teste.data.repository.profile.implementation

import com.luan.teste.common.base.ApiResult
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.profile.model.toDomain
import com.luan.teste.domain.model.profile.User
import com.luan.teste.domain.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class ProfileRepositoryImpl(
    private val profileDataSource: ProfileDataSource
): ProfileRepository {
    override suspend fun getUsers(): Flow<ApiResult<List<User>>> = flow {
        profileDataSource.getUsers()
            .catch { emit(ApiResult.Error<List<User>>(it)) }
            .collect { list ->
                val newList = list.map { it.toDomain() }
                emit(ApiResult.Success(newList))
            }
    }.flowOn(Dispatchers.IO)

    override suspend fun getUserByUsername(username: String): Flow<ApiResult<User>> = flow {
        profileDataSource.getUsersByUsername(username)
            .catch { emit(ApiResult.Error<User>(it)) }
            .collect {
                emit(ApiResult.Success(it.toDomain()))
            }
    }.flowOn(Dispatchers.IO)
}