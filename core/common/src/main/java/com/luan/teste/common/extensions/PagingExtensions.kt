package com.luan.teste.common.extensions

import androidx.paging.PagingData
import kotlinx.coroutines.flow.flow

fun <T: Any> PagingData<T>.flow() = flow<PagingData<T>> {
    emit(this@flow)
}