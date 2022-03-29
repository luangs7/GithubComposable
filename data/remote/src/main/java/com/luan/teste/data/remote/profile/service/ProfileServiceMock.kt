package com.luan.teste.data.remote.profile.service

import com.luan.teste.data.remote.profile.model.UserResponse
import kotlinx.coroutines.delay
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

class ProfileServiceMock: ProfileService {
    override suspend fun getUsers(): Response<List<UserResponse>> {
        delay(3000)
        return Response.success(listOf())
    }

    override suspend fun getUsersByUsername(username: String): Response<UserResponse> {
        delay(3000)
        return Response.success(null)
    }

}