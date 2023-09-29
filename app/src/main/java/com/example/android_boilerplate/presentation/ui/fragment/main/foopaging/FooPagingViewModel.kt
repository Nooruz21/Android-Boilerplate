package com.example.android_boilerplate.presentation.ui.fragment.main.foopaging

import com.example.android_boilerplate.presentation.base.BaseViewModel
import com.example.android_boilerplate.presentation.models.foo.toUI
import com.example.domain.usecase.foopaging.FetchFooPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FooPagingViewModel @Inject constructor(
    fetchFooPagingUseCase: FetchFooPagingUseCase
) : BaseViewModel() {

    val fooPaging = fetchFooPagingUseCase().collectPagingRequest { it.toUI() }
}