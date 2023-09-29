package com.example.domain.usecase.foo

import com.example.domain.repositories.FooRepository
import javax.inject.Inject

class GetFooUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.getFoo()
}
