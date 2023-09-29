package com.example.domain.usecase.foopaging

import com.example.domain.repositories.FooRepository
import javax.inject.Inject

class FetchFooPagingUseCase @Inject constructor(
    private val repository: FooRepository
) {
    operator fun invoke() = repository.fetchFooPaging()
}