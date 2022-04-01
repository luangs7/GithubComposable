package com.luan.teste.data.remote.profile.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.luan.teste.data.remote.profile.model.toRepo
import com.luan.teste.data.remote.profile.paging.ProfilePageSource
import com.luan.teste.data.remote.profile.paging.ProfilePageSourceCall
import com.luan.teste.data.remote.profile.service.ProfileService
import com.luan.teste.data.remote.utils.resultFlow
import com.luan.teste.data.repository.profile.datasource.ProfileDataSource
import com.luan.teste.data.repository.profile.model.UserData
import kotlinx.coroutines.flow.*
import retrofit2.Response

class ProfileDataSourceImpl(
    private val profileService: ProfileService
) : ProfileDataSource {
    override suspend fun getUsers(query: String?): Flow<PagingData<UserData>> = Pager(
        config = PagingConfig(30, prefetchDistance = 2),
        pagingSourceFactory = {
            ProfilePageSource(
                profileService,
                if (query.isNullOrEmpty()) ProfilePageSourceCall.LIST else ProfilePageSourceCall.SEARCH,
                query
            )
        }
    ).flow.map {
        it.map { response -> response.toRepo() }
    }

    override suspend fun getUsersByUsername(username: String): Flow<UserData> = flow {
        profileService.getUsersByUsername(username).resultFlow().collect {
            emit(it.toRepo())
        }
    }

}