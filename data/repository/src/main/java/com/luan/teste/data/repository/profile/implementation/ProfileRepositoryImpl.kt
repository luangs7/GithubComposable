package com.luan.teste.data.repository.profile.implementation

import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.luan.teste.common.base.ApiResult
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.profile.model.toDomain
import com.luan.teste.domain.model.profile.User
import com.luan.teste.domain.repository.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class ProfileRepositoryImpl(
    private val profileDataSource: ProfileDataSource,
    private val scope: CoroutineScope
): ProfileRepository {
    override suspend fun getUsers(query: String?): Flow<ApiResult<PagingData<User>>> = flow {
        emit(ApiResult.Loading)
        profileDataSource.getUsers(query)
            .catch { emit(ApiResult.Error<PagingData<User>>(it)) }
            .cachedIn(scope)
            .collect { list ->
                val newList = list.map { it.toDomain() }
                emit(ApiResult.Success(newList))
            }
    }.flowOn(Dispatchers.IO)

    override suspend fun getUserByUsername(username: String): Flow<ApiResult<User>> = flow {
        emit(ApiResult.Loading)
        profileDataSource.getUsersByUsername(username)
            .catch { emit(ApiResult.Error<User>(it)) }
            .collect {
                emit(ApiResult.Success(it.toDomain()))
            }
    }.flowOn(Dispatchers.IO)
}