package com.luan.teste.domain.interactor

import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.UseCase
import com.luan.teste.domain.model.profile.User
import kotlinx.coroutines.flow.Flow

abstract class GetUserUseCase: UseCase<Unit, Flow<ApiResult<List<User>>>>()