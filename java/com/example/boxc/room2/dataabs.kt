package com.example.boxc.room2

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.boxc.room.roomDAO

@Database(entities = [dataclass::class] , version = 7)
abstract class dataabs : RoomDatabase() {
    abstract fun ud(): dataDao
}