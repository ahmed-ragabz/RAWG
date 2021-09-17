package com.ragabz.rawg.data.datasource.remote.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        chain.request().let {
            val newRequest = it.newBuilder()
            newRequest.url(
                it.url.newBuilder()
                    .addQueryParameter("key", "0bdd83c1218642ffaa1dd675fec60776")
                    .build()
            )
            return chain.proceed(newRequest.build())
        }
    }
}