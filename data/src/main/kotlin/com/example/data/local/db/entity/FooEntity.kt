package com.example.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.remote.dtos.foo.FooDto
import com.example.data.utils.DataMapper
import com.example.domain.model.Foo

@Entity(tableName = "foo")
class FooEntity(
    @PrimaryKey
    val id: Long,
    val bar: String
) : DataMapper<Foo> {

    override fun mapToDomain() = Foo(id, bar)
}

fun FooDto.toEntity() = FooEntity(id, bar)