package com.example.data.remote.client

import com.example.data.remote.apiservices.FooApiService
import com.example.data.remote.client.interceptors.AuthorizationInterceptor
import retrofit2.create

class NetworkClient constructor(
    authorizationInterceptor: AuthorizationInterceptor
) {

    private val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().apply {
            addInterceptor(authorizationInterceptor)
        }.build()
    )

    fun provideFooApiService(): FooApiService = provideRetrofit.create()
}