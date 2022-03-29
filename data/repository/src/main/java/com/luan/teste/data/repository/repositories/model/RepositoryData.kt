package com.luan.teste.data.repository.repositories.model

data class RepositoryData(
    val id: Int,
    val name:String,
    val fullName:String,
    val owner: OwnerData,
    val description:String,
    val starCount: Int
)