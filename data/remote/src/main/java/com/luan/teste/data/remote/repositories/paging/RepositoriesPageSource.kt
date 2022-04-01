package com.luan.teste.data.remote.repositories.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.luan.teste.data.remote.repositories.model.RepositoryResponse
import com.luan.teste.data.remote.repositories.service.RepositoriesService

class RepositoriesPageSource(
    private val service:RepositoriesService
): PagingSource<Int, RepositoryResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RepositoryResponse> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getRepositories(pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.items

            LoadResult.Page(
                data = data ?: listOf(),
                prevKey = null,
                nextKey = pageNumber.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RepositoryResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}