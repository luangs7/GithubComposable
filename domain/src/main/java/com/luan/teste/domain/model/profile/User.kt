package com.luan.teste.domain.model.profile

data class User(
    val avatar: String,
    val bio: String,
    val blog: String,
    val company: String,
    val email: String,
    val followers: Int,
    val following: Int,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val twitter_username: String,
    val url: String
)