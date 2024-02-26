package com.example.movieapp_try1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ResultsEntity::class],
    version = 1
)/*
@TypeConverters(ResultsListConverter::class)*/
abstract class MovieDatabase: RoomDatabase() {
    abstract val dao: MovieDao
}