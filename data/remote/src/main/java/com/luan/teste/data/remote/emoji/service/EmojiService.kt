package com.luan.teste.data.remote.emoji.service

import com.luan.teste.data.remote.emoji.model.EmojiResponse
import retrofit2.Response
import retrofit2.http.GET

interface EmojiService {
    @GET("emojis")
    suspend fun getEmojis():Response<List<EmojiResponse>>
}