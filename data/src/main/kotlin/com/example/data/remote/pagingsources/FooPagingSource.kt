package com.example.data.remote.pagingsources

import com.example.data.base.BasePagingSource
import com.example.data.remote.apiservices.FooApiService
import com.example.data.remote.dtos.foo.FooDto
import com.example.domain.model.Foo

class FooPagingSource(
    private val service: FooApiService
) : BasePagingSource<FooDto, Foo>(
    { service.fetchFooPaging(it) }
)