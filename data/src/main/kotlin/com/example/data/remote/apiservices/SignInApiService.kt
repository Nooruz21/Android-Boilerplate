package com.example.data.remote.apiservices

import com.example.data.remote.dtos.sign.SignInResponse
import com.example.data.remote.dtos.sign.UserSignInDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST
    suspend fun signIn(@Body userSignInDto: UserSignInDto): Response<SignInResponse>
}