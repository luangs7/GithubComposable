package com.luan.teste.data.remote.profile.model


import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    @SerializedName("items")
    val items: List<UserResponse>
)