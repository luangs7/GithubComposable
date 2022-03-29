package com.luan.teste.data.repository.profile.datasource

import com.luan.teste.data.repository.profile.model.UserData
import kotlinx.coroutines.flow.Flow

interface ProfileDataSource {
    suspend fun getUsers(): Flow<List<UserData>>
    suspend fun getUsersByUsername(username: String): Flow<UserData>
}