package com.luan.teste.common.base

data class ViewState<T>(
    var isLoading: Boolean = false,
    var isEmpty: Boolean = false,
    var error: Throwable? = null,
    var result: T? = null
)