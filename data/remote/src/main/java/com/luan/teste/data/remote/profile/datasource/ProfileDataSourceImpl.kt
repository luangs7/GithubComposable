package com.luan.teste.data.remote.profile.datasource

import com.luan.teste.data.remote.profile.model.toRepo
import com.luan.teste.data.remote.profile.service.ProfileService
import com.luan.teste.data.remote.utils.resultFlow
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.profile.model.UserData
import kotlinx.coroutines.flow.*
import retrofit2.Response

class ProfileDataSourceImpl(
    private val profileService: ProfileService
) : ProfileDataSource {
    override suspend fun getUsers(): Flow<List<UserData>> = flow {
        profileService.getUsers().resultFlow().collect { list ->
            emit(list.map { it.toRepo() })
        }
    }

    override suspend fun getUsersByUsername(username: String): Flow<UserData> = flow {
        profileService.getUsersByUsername(username).resultFlow().collect {
            emit(it.toRepo())
        }
    }
}