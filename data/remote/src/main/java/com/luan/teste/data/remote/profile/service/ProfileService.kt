package com.luan.teste.data.remote.profile.service

import com.luan.teste.data.remote.profile.model.UserResponse
import com.luan.teste.data.remote.profile.model.UserSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {

    @GET("users")
    suspend fun getUsers(@Query("since") page:Int, @Query("per_page") perPage:Int = 20): Response<List<UserResponse>>

    @GET("search/users")
    suspend fun getUsers(@Query("q") query:String, @Query("page") page:Int): Response<UserSearchResponse>

    @GET("users/{username}")
    suspend fun getUsersByUsername(@Path("username") username: String): Response<UserResponse>
}