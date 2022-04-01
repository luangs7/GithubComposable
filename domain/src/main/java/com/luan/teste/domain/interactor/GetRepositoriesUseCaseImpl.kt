package com.luan.teste.domain.interactor

import androidx.paging.PagingData
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.UseCase
import com.luan.teste.domain.model.profile.User
import com.luan.teste.domain.model.repositories.Repository
import com.luan.teste.domain.repository.RepositoriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRepositoriesUseCaseImpl(
    private val repository: RepositoriesRepository
) : GetRepositoriesUseCase() {
    override suspend fun execute(params: Unit): Flow<ApiResult<PagingData<Repository>>> =
        repository.getRepositories()
}