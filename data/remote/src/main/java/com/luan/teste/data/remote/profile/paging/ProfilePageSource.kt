package com.luan.teste.data.remote.profile.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luan.teste.data.remote.profile.model.UserResponse
import com.luan.teste.data.remote.profile.service.ProfileService

enum class ProfilePageSourceCall {
    LIST, SEARCH
}

class ProfilePageSource(
    private val service: ProfileService,
    private val sourceCall: ProfilePageSourceCall,
    private val query: String?
) : PagingSource<Int, UserResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse> {
        val pageNumber = params.key ?: 1
        return try {

            val response = when(sourceCall){
                ProfilePageSourceCall.LIST -> service.getUsers(pageNumber).body()
                ProfilePageSourceCall.SEARCH -> service.getUsers(query.orEmpty(),pageNumber).body()?.items
            }

            LoadResult.Page(
                data = response ?: listOf(),
                prevKey = null,
                nextKey = pageNumber.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}