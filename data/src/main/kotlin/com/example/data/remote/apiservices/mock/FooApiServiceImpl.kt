package com.example.data.remote.apiservices.mock

import android.content.Context
import com.example.data.remote.apiservices.FooApiService
import com.example.data.remote.dtos.foo.FooDto
import com.example.data.remote.dtos.foo.FooPagingResponse
import com.example.data.utils.fromJson
import com.example.data.utils.jsonFromAssets
import kotlinx.coroutines.delay
import retrofit2.Response
import javax.inject.Inject

/**
 * Mock class
 */
class FooApiServiceImpl @Inject constructor(
    private val context: Context
) : FooApiService {

    override suspend fun fetchFoo(): Response<FooDto> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPrimitives(): Response<String> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchFooList(): Response<List<FooDto>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchFooPaging(page: Int): Response<FooPagingResponse<FooDto>> {
        delay(2000)
        return when (page) {
            1 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage1.json")))
            }
            2 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage2.json")))
            }
            3 -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage3.json")))
            }
            else -> {
                Response.success(fromJson(context.jsonFromAssets("FooPagingPage4.json")))
            }
        }
    }

}