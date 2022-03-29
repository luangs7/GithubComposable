package com.luan.teste.domain.model.repositories

data class Repository(
    val id: Int,
    val name:String,
    val fullName:String,
    val owner: Owner,
    val description:String,
    val starCount: Int
)