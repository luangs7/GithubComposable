@file:Suppress("SpellCheckingInspection")

package com.luan.teste.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.luan.teste.data.local.emoji.EmojiEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface EmojiDao {
    @Insert(onConflict = REPLACE)
    fun saveList(list: List<EmojiEntity>)

    @Query("SELECT * FROM emojientity")
    fun getList(): Flow<List<EmojiEntity>>

    @Delete
    fun delete(emojiEntity: EmojiEntity)
}