package com.example.data.remote.dtos.foo

import com.google.gson.annotations.SerializedName

data class FooPagingResponse<T>(
    @SerializedName("prev")
    val prev: Int?,
    @SerializedName("next")
    val next: Int?,
    @SerializedName("data")
    val data: MutableList<T>
)
