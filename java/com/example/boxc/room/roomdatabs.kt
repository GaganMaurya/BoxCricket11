package com.example.boxc.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [roomdataclass::class] , version = 7)
abstract class roomdatabs : RoomDatabase() {
    abstract fun userDao(): roomDAO
}