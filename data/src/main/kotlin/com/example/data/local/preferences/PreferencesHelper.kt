package com.example.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.data.local.preferences.PreferencesConst.PREF_ID_TOKEN
import com.example.data.local.preferences.PreferencesConst.PREF_IS_AUTHORIZE

class PreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("boilerplate.preferences", Context.MODE_PRIVATE)

    private fun remove(key: String){
        preferences.edit().remove(key).apply()
    }

    var isAuthorize: Boolean
        get() = preferences.getBoolean(PREF_IS_AUTHORIZE, false)
        set(value) = preferences.edit().putBoolean(PREF_IS_AUTHORIZE, value).apply()

    var token: String
        get() = preferences.getString(PREF_ID_TOKEN, "")!!
        set(value) = preferences.edit().putString(PREF_ID_TOKEN, value).apply()
}