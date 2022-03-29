package com.luan.teste.data.repository.emoji.implementation

import com.luan.teste.common.base.ApiResult
import com.luan.teste.data.repository.emoji.datasource.EmojiLocalDataSource
import com.luan.teste.data.repository.emoji.datasource.EmojiRemoteDataSource
import com.luan.teste.data.repository.emoji.model.EmojiData
import com.luan.teste.data.repository.emoji.model.toDomain
import com.luan.teste.domain.model.emoji.Emoji
import com.luan.teste.domain.repository.EmojiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class EmojiRepositoryImpl(
    private val emojiRemoteDataSource: EmojiRemoteDataSource,
    private val emojiLocalDataSource: EmojiLocalDataSource
) : EmojiRepository {
    override suspend fun getEmojis(): Flow<ApiResult<List<Emoji>>> = flow {
        emit(ApiResult.Loading)
        emojiRemoteDataSource.getEmojis()
            .catch {
                emojiLocalDataSource.getEmojis()
                    .catch { emit(ApiResult.Error<List<Emoji>>(it)) }
                    .collect { emit(mapToEmit(it)) }
            }.collect {
                emojiLocalDataSource.saveEmojis(it)
                emit(mapToEmit(it))
            }
    }.flowOn(Dispatchers.IO)

    private fun mapToEmit(list: List<EmojiData>):ApiResult<List<Emoji>> {
        if(list.isEmpty()) return ApiResult.Empty
        val result = list.map { it.toDomain() }
        return ApiResult.Success(result)
    }
}