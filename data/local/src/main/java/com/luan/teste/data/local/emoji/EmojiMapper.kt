package com.luan.teste.data.local.emoji

import com.luan.teste.data.repository.emoji.model.EmojiData


fun EmojiEntity.toRepo(): EmojiData {
    return EmojiData(source)
}

fun EmojiData.toEntity(): EmojiEntity{
    return EmojiEntity(source)
}