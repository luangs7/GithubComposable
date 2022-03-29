package com.luan.teste.domain.interactor

import com.luan.teste.common.base.ApiResult
import com.luan.teste.common.base.UseCase
import com.luan.teste.domain.model.emoji.Emoji
import kotlinx.coroutines.flow.Flow

abstract class GetEmojiListUseCase: UseCase<Unit, Flow<ApiResult<List<Emoji>>>>()