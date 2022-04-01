package com.luan.teste.data.remote.emoji.service

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.luan.teste.data.remote.emoji.model.EmojiResponse
import java.lang.reflect.Type

class EmojiConverterFactory : JsonDeserializer<List<EmojiResponse>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): List<EmojiResponse> {
        return json?.asJsonObject!!.entrySet().map {
            it.key
            it.value
            EmojiResponse(source = it.value.asString)
        }
    }

}