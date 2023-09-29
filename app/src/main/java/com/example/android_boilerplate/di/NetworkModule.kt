package com.example.android_boilerplate.di

import android.content.Context
import com.example.data.remote.apiservices.SignInApiService
import com.example.data.remote.apiservices.mock.SignInApiServiceImpl
import com.example.data.remote.client.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideSignInApiService(
        @ApplicationContext context: Context
    ): SignInApiService {
        return SignInApiServiceImpl(context)
    }
}