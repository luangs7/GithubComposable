package com.luan.teste.data.remote.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

suspend fun <T> Response<T>.resultFlow(): Flow<T> = flow {
    if (isSuccessful) {
        body()?.let {
            emit(it)
        } ?: throw Exception()
    } else {
        errorBody()?.let {
            val error = it.string()
            it.close()
            throw Exception(error)
        }
    }
}.flowOn(Dispatchers.IO)