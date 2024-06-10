package com.example.data.datasource.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        AnimeEntity:: class
    ],
    version = 3,
)
abstract class AppDatabase: RoomDatabase(){
    companion object{
        const val DATABASE_NAME = "APP_DATABASE"
    }

    abstract fun animeDao(): AnimeDao
}