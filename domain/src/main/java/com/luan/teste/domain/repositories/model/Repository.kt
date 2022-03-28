package com.luan.teste.domain.repositories.model

data class Repository(
    private val id:String,
    private val name:String,
    private val fullName:String,
    private val owner:String,
    private val description:String
)