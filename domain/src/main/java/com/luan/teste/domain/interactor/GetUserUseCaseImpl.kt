package com.luan.teste.domain.interactor

import androidx.paging.PagingData
import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.UseCase
import com.luan.teste.domain.model.profile.User
import com.luan.teste.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetUserUseCaseImpl(
    private val repository: ProfileRepository
): GetUserUseCase(){
    override suspend fun execute(params: String?): Flow<ApiResult<PagingData<User>>> = repository.getUsers(params)
}