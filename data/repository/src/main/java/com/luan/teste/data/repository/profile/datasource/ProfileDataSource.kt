package com.luan.teste.data.repository.profile.datasource

import androidx.paging.PagingData
import com.luan.teste.data.repository.profile.model.UserData
import kotlinx.coroutines.flow.Flow

interface ProfileDataSource {
    suspend fun getUsers(query: String?): Flow<PagingData<UserData>>
    suspend fun getUsersByUsername(username: String): Flow<UserData>
}