package com.example.android_boilerplate.di

import com.example.data.remote.client.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideFooApiService(
        networkClient: NetworkClient
    ) = networkClient.provideFooApiService()
}