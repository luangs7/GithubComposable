package com.luan.teste.data.remote.profile.service

import com.luan.teste.data.remote.profile.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {

    @GET("user")
    suspend fun getUsers(): Response<List<UserResponse>>

    @GET("users/{username}")
    suspend fun getUsersByUsername(@Path("username") username: String): Response<UserResponse>
}