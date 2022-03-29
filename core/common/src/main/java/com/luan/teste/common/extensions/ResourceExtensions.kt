package com.luan.teste.common.extensions

import com.luan.teste.common.base.ApiResult


fun <T> ApiResult<T>.isSuccess():Boolean = this is ApiResult.Success
fun <T> ApiResult<T>.isError():Boolean = this is ApiResult.Error
