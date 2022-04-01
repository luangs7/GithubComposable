package com.luan.teste.data.remote.repositories.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.luan.teste.data.remote.repositories.model.toRepo
import com.luan.teste.data.remote.repositories.paging.RepositoriesPageSource
import com.luan.teste.data.remote.repositories.service.RepositoriesService
import com.luan.teste.data.repository.repositories.datasource.RepositoriesDataSource
import com.luan.teste.data.repository.repositories.model.RepositoryData
import kotlinx.coroutines.flow.*

class RepositoriesDataSourceImpl(
    private val service: RepositoriesService
) : RepositoriesDataSource {
    override suspend fun getRepositories(): Flow<PagingData<RepositoryData>> = Pager(
        config = PagingConfig(30,prefetchDistance = 2),
        pagingSourceFactory = { RepositoriesPageSource(service) }
    ).flow.map {
        it.map { response -> response.toRepo() }
    }
}

