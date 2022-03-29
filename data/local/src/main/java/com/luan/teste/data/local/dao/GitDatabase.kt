package com.luan.teste.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luan.teste.data.local.emoji.EmojiEntity

@Database(
    entities = [EmojiEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GitDatabase : RoomDatabase() {
    abstract val emojiDao: EmojiDao

    companion object{
        const val EMOJI_TABLE_NAME = "emoji"
    }
}