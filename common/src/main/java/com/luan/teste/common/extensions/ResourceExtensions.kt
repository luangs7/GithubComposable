package com.luan.teste.common.extensions

import com.luan.teste.common.base.Resource


fun <T> Resource<T>.isSuccess():Boolean = this is Resource.Success
fun <T> Resource<T>.isError():Boolean = this is Resource.Error
