package com.luan.teste.domain.interactor

import com.luan.teste.common.base.ApiResult
import com.luan.teste.domain.model.profile.User
import com.luan.teste.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.security.InvalidParameterException

class GetUserByNameUseCaseImpl(
    private val repository: ProfileRepository
) : GetUserByNameUseCase() {
    override suspend fun execute(params: String): Flow<ApiResult<User>> = flow {
        if (params.isEmpty()) emit(ApiResult.Error(InvalidParameterException()))
        else repository.getUserByUsername(params).collect { emit(it) }
    }
}