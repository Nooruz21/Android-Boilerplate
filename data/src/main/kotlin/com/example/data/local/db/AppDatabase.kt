package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.db.dao.FooDao
import com.example.data.local.db.entity.FooEntity

@Database(entities = [FooEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fooDao(): FooDao
}