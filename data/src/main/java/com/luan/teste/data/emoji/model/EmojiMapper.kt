package com.luan.teste.data.emoji.model

import com.luan.teste.domain.emoji.model.Emoji

fun EmojiEntity.toDomain(): Emoji {
    return Emoji(source)
}

fun EmojiResponse.toEntity(): EmojiEntity{
    return EmojiEntity(source)
}

fun EmojiResponse.toDomain(): Emoji {
    return Emoji(source)
}