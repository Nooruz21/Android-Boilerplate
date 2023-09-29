package com.example.domain.usecase.sign

import com.example.domain.model.sign.UserSignIn
import com.example.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    operator fun invoke(userSignIn: UserSignIn) = repository.signIn(userSignIn)
}