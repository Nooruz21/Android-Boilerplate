package com.example.domain.repositories

import com.example.domain.core.Either
import com.example.domain.core.NetworkError
import com.example.domain.model.sign.SignIn
import com.example.domain.model.sign.UserSignIn
import kotlinx.coroutines.flow.Flow

interface SignInRepository {

    fun signIn(userSignIn: UserSignIn): Flow<Either<NetworkError, SignIn>>
}