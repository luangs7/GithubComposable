package com.luan.teste.data.remote.emoji.datasource

import com.luan.teste.data.remote.emoji.model.toRepo
import com.luan.teste.data.remote.emoji.service.EmojiService
import com.luan.teste.data.remote.utils.resultFlow
import com.luan.teste.data.repository.emoji.datasource.EmojiRemoteDataSource
import com.luan.teste.data.repository.emoji.model.EmojiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.security.InvalidParameterException

class EmojiRemoteDataSourceImpl(
    private val service: EmojiService
) : EmojiRemoteDataSource {
    override suspend fun getEmojis(): Flow<List<EmojiData>> = flow {
        service.getEmojis().resultFlow().collect { list ->
            emit(list.map { it.toRepo() })
        }
    }.flowOn(Dispatchers.IO)
}