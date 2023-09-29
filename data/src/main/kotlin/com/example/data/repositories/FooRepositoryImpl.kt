package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.local.db.dao.FooDao
import com.example.data.local.db.entity.toEntity
import com.example.data.remote.apiservices.FooApiService
import com.example.data.remote.pagingsources.FooPagingSource
import com.example.domain.repositories.FooRepository
import javax.inject.Inject

class FooRepositoryImpl @Inject constructor(
    private val service: FooApiService,
    private val dao: FooDao
) : BaseRepository(), FooRepository {

    override fun fetchFoo() = doNetworkRequestWithMapping {
        service.fetchFoo().onSuccess { data ->
            dao.insertFoo(data.toEntity())
        }
    }

    override fun fetchPrimitives() = doNetworkRequestWithoutMapping {
        service.fetchPrimitives()
    }

    override fun fetchFooList() = doNetworkRequestForList {
        service.fetchFooList()
    }

    override fun fetchFooUnit() = doNetworkRequestUnit {
        service.fetchFoo()
    }

    override fun fetchFooPaging() = doPagingRequest({
        FooPagingSource(service)
    })

    override fun getFoo() = doLocalRequestForList {
        dao.getAllFoo()
    }
}