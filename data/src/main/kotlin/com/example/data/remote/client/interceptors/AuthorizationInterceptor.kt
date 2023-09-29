package com.example.data.remote.client.interceptors

import com.example.data.local.preferences.PreferencesHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val preferencesHelper: PreferencesHelper
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestBuilder = request
            .newBuilder()
            .addHeader("Authorization", "Token ${preferencesHelper.token}")

        with(preferencesHelper) {
            if (!isAuthorize || token.isEmpty()) {
                requestBuilder.removeHeader("Authorization")
            }
        }

        return chain.proceed(request)
    }
}