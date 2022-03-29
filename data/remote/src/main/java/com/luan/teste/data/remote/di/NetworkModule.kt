package com.luan.teste.data.remote.di

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.luan.teste.data.remote.BuildConfig
import com.luan.teste.data.remote.authorization.AuthorizationInterceptor
import com.luan.teste.data.remote.emoji.model.EmojiResponse
import com.luan.teste.data.remote.emoji.service.EmojiConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

object NetworkModule {

    val modules = module {

        single { provideOkHttpClient() }

        single { provideRetrofit(get()) }
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .followRedirects(true)
            .addInterceptor(AuthorizationInterceptor())
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        return builder.build()
    }


    private fun provideRetrofit(
        client: OkHttpClient
    ): Retrofit {
        val listType: Type = object : TypeToken<MutableList<EmojiResponse>>() {}.type
        val builder = GsonBuilder().registerTypeAdapter(listType, EmojiConverterFactory())

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(builder.create()))
            .build()
    }
}