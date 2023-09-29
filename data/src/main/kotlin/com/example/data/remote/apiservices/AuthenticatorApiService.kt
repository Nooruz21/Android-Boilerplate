package com.example.data.remote.apiservices

import com.example.data.remote.dtos.token.RefreshToken
import com.example.data.remote.dtos.token.Tokens
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticatorApiService {
    @POST("/api/refreshtoken")
    fun refreshToken(@Body refreshToken: RefreshToken): Call<Tokens>
}