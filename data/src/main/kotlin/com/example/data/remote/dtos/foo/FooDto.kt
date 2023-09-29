package com.example.data.remote.dtos.foo

import com.example.data.utils.DataMapper
import com.example.domain.model.Foo
import com.google.gson.annotations.SerializedName

data class FooDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("bar")
    val bar: String
): DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}
