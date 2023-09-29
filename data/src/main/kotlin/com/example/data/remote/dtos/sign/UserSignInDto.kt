package com.example.data.remote.dtos.sign

import com.example.domain.model.sign.UserSignIn
import com.google.gson.annotations.SerializedName

class UserSignInDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

fun UserSignIn.fromDomain() = UserSignInDto(
    username,
    password
)