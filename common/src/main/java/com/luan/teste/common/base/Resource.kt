package com.luan.teste.common.base

sealed class Resource<out T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val error: Throwable) : Resource<T>()
    object Loading : Resource<Nothing>()
    object Empty : Resource<Nothing>()
}
