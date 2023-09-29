package com.example.android_boilerplate.presentation.models.foo

import com.example.android_boilerplate.presentation.base.IBaseDiffModel
import com.example.domain.model.Foo


data class FooUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Foo.toUI() = FooUI(id, bar)