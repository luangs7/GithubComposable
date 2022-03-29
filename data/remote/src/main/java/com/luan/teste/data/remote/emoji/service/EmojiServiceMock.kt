package com.luan.teste.data.remote.emoji.service

import com.luan.teste.data.remote.emoji.model.EmojiResponse
import kotlinx.coroutines.delay
import retrofit2.Response

class EmojiServiceMock : EmojiService {
    override suspend fun getEmojis(): Response<List<EmojiResponse>> {
        delay(3000)
        return Response.success(
            listOf(
                EmojiResponse(
                    "https://github.githubassets.com/images/icons/emoji/unicode/1f948.png?v8"
                ),
                EmojiResponse(
                    "https://github.githubassets.com/images/icons/emoji/unicode/1f9ee.png?v8"
                ),
                EmojiResponse(
                    "https://github.githubassets.com/images/icons/emoji/unicode/1f948.png?v8"
                ),
                EmojiResponse(
                    "https://github.githubassets.com/images/icons/emoji/unicode/1f9ee.png?v8"
                )
            )
        )
    }
}