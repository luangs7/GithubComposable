package com.luan.teste.data.emoji.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmojiEntity(
    @PrimaryKey
    var source: String
)