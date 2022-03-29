package com.luan.teste.data.repository.emoji.model

import com.luan.teste.domain.model.emoji.Emoji

fun EmojiData.toDomain(): Emoji = Emoji(source)

fun Emoji.toRepo(): EmojiData = EmojiData(source)