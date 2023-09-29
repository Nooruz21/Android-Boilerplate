package com.example.data.remote.dtos.sign

import com.example.data.utils.DataMapper
import com.example.domain.model.sign.SignIn
import com.google.gson.annotations.SerializedName

class SignInResponse(
    @SerializedName("token")
    val token: String
) : DataMapper<SignIn> {

    override fun mapToDomain() = SignIn(
        token
    )
}