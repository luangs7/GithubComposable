package com.luan.teste.domain.interactor

import com.luan.teste.common.base.ApiResult
import com.luan.teste.domain.model.emoji.Emoji
import com.luan.teste.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.Flow

class GetEmojiListUseCaseImpl(
    private val emojiRepository: EmojiRepository
): GetEmojiListUseCase() {
    override suspend fun execute(params: Unit): Flow<ApiResult<List<Emoji>>> = emojiRepository.getEmojis()
}