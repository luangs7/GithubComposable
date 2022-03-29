package com.luan.teste.data.remote.profile.datasource

import com.luan.teste.data.remote.profile.model.toRepo
import com.luan.teste.data.remote.profile.service.ProfileService
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.profile.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ProfileDataSourceImpl(
    private val profileService: ProfileService
) : ProfileDataSource {
    override suspend fun getUsers(): Flow<List<UserData>> = flow {
        val response = profileService.getUsers()
        if (response.isSuccessful) {
            response.body()?.let { list ->
                emit(list.map { it.toRepo() })
            } ?: throw Exception()
        } else {
            throw Exception()
        }
    }

    override suspend fun getUsersByUsername(username: String): Flow<UserData> = flow{
        val response = profileService.getUsersByUsername(username)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.toRepo())
            } ?: throw Exception()
        } else {
            throw Exception()
        }
    }
}