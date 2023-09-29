package com.example.data.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * Moshi instance
 *
 * @see KotlinJsonAdapterFactory
 */
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

/**
 * Convert from json
 *
 * @return [T] our model
 */
internal inline fun <reified T> fromJsonMoshi(value: String): T? {
    return moshi.adapter(T::class.java).fromJson(value)
}

/**
 * Convert Json file to [T] (our model)
 *z
 * @return [T]
 */
internal inline fun <reified T> fromJson(file: String): T {
    return Gson().fromJson(file, object : TypeToken<T>() {}.type)
}

/**
 * Convert to json
 *
 * @return [String] json in string
 */
internal inline fun <reified T> toJson(generic: T?): String {
    return moshi.adapter(T::class.java).toJson(generic)
}

/**
 * Get Json from [assets][Context.getAssets]
 *
 * @return Json file from [assets][Context.getAssets]
 */
internal fun Context.jsonFromAssets(fileName: String): String {
    return this.assets.open(fileName).bufferedReader().use { it.readText() }
}