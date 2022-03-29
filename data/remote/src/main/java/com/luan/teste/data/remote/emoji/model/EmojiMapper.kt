package com.luan.teste.data.remote.emoji.model

import com.luan.teste.data.repository.emoji.model.EmojiData

fun EmojiResponse.toRepo(): EmojiData {
    return EmojiData(source)
}