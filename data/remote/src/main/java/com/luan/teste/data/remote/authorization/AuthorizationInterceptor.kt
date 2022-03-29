package com.luan.teste.data.remote.authorization

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        request.newBuilder().addHeader("Authorization", "token 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").build()

        return chain.proceed(request)
    }
}