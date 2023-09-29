package com.example.data.remote.apiservices.mock

import android.content.Context
import com.example.data.remote.apiservices.SignInApiService
import com.example.data.remote.dtos.sign.SignInResponse
import com.example.data.remote.dtos.sign.UserSignInDto
import com.example.data.utils.fromJson
import com.example.data.utils.jsonFromAssets
import kotlinx.coroutines.delay
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

/**
 * Mock class
 */
class SignInApiServiceImpl @Inject constructor(
    private val context: Context
) : SignInApiService {

    override suspend fun signIn(userSignInDto: UserSignInDto): Response<SignInResponse> {
        delay(1000)
        return if (userSignInDto.username == "OnePunchMan" && userSignInDto.password == "Fubuk1") {
            Response.success(fromJson(context.jsonFromAssets("SignInResponse.json")))
        } else {
            Response.error(422, context.jsonFromAssets("ErrorBody.json").toResponseBody())
        }
    }
}