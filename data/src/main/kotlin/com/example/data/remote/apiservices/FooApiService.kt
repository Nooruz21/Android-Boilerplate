package com.example.data.remote.apiservices

import com.example.data.remote.dtos.foo.FooDto
import com.example.data.remote.dtos.foo.FooPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FooApiService {
    @GET("/api/foo")
    suspend fun fetchFoo(): Response<FooDto>

    @GET("/api/foo")
    suspend fun fetchPrimitives(): Response<String>

    @GET("/api/foo")
    suspend fun fetchFooList(): Response<List<FooDto>>

    @GET("/api/foo")
    suspend fun fetchFooPaging(@Query("page") page: Int): Response<FooPagingResponse<FooDto>>
}