package com.example.domain.repositories

import com.example.domain.core.RemotePagingWrapper
import com.example.domain.core.RemoteWrapper
import com.example.domain.model.Foo
import kotlinx.coroutines.flow.Flow


interface FooRepository {

    fun fetchFoo(): RemoteWrapper<Foo>

    fun fetchPrimitives(): RemoteWrapper<String>

    fun fetchFooList(): RemoteWrapper<List<Foo>>

    fun fetchFooUnit(): RemoteWrapper<Unit>

    fun fetchFooPaging(): RemotePagingWrapper<Foo>

    fun getFoo(): Flow<List<Foo>>
}