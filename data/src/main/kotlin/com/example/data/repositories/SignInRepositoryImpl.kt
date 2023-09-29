package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apiservices.SignInApiService
import com.example.data.remote.dtos.sign.fromDomain
import com.example.domain.model.sign.UserSignIn
import com.example.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val service: SignInApiService
) : BaseRepository(), SignInRepository {

    override fun signIn(userSignIn: UserSignIn) = doNetworkRequest {
        service.signIn(userSignIn.fromDomain()).onSuccess { data ->
            /**
             * Do something with [data]
             */
            data.token
        }
    }
}