package com.example.android_boilerplate.presentation.ui.fragment.main.foo

import com.example.android_boilerplate.presentation.base.BaseViewModel
import com.example.android_boilerplate.presentation.models.foo.FooUI
import com.example.android_boilerplate.presentation.models.foo.toUI
import com.example.domain.usecase.foo.FetchFooUseCase
import com.example.domain.usecase.foo.GetFooUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val fetchFooUseCase: FetchFooUseCase,
    private val getFooUseCase: GetFooUseCase
) : BaseViewModel() {

    private val _fooState = MutableUIStateFlow<FooUI>()
    val fooState = _fooState.asStateFlow()

    fun fetchFoo() {
        fetchFooUseCase().collectNetworkRequest(_fooState) { it.toUI() }
    }

    fun getFoo() = getFooUseCase().collectLocalRequestForList { it.toUI() }
}