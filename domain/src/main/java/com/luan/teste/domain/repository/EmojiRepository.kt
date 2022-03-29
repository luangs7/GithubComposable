package com.luan.teste.domain.repository

import com.luan.teste.common.base.ApiResult
import com.luan.teste.domain.model.emoji.Emoji
import kotlinx.coroutines.flow.Flow

interface EmojiRepository {
    suspend fun getEmojis():Flow<ApiResult<List<Emoji>>>
}