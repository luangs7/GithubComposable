package com.luan.teste.data.repository.emoji.datasource

import com.luan.teste.data.repository.emoji.model.EmojiData
import kotlinx.coroutines.flow.Flow

interface EmojiLocalDataSource {
    suspend fun getEmojis(): Flow<List<EmojiData>>
    suspend fun saveEmojis(list: List<EmojiData>)
}