package com.luan.teste.data.local.emoji

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmojiEntity(
    @PrimaryKey
    var source: String
)