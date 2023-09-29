package com.example.android_boilerplate.presentation.extention

import android.util.Log
import android.view.View
import com.example.android_boilerplate.presentation.utils.OnSingleClickListener

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.setOnSingleClickListener(l: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener(l))
}

fun loge(msg: String, value: Any? = null) = Log.e("TAG", msg + value)