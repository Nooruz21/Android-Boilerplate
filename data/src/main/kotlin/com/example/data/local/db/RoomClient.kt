package com.example.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.data.local.db.dao.FooDao

class RoomClient {

    fun provideAppDatabase(context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, "boilerplate.db")
        .build()

    fun provideFooDao(appDatabase: AppDatabase): FooDao = appDatabase.fooDao()
}