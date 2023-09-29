package com.example.android_boilerplate.di

import com.example.data.repositories.FooRepositoryImpl
import com.example.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindFooRepository(
        repositoryImpl: FooRepositoryImpl
    ): FooRepository
}