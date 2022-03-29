package com.luan.teste.data.local.emoji.datasource

import com.luan.teste.data.local.dao.EmojiDao
import com.luan.teste.data.local.emoji.toEntity
import com.luan.teste.data.local.emoji.toRepo
import com.luan.teste.data.repository.emoji.datasource.EmojiLocalDataSource
import com.luan.teste.data.repository.emoji.model.EmojiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class EmojiLocalDataSourceImpl(
    private val dao: EmojiDao
) : EmojiLocalDataSource {
    override suspend fun getEmojis(): Flow<List<EmojiData>> = flow {
        dao.getList().collect { list ->
            emit(list.map { it.toRepo() })
        }
    }

    override suspend fun saveEmojis(list: List<EmojiData>) {
        val entityList = list.map { it.toEntity() }
        dao.saveList(entityList)
    }
}