package com.example.boxc.room3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [tprevdataclass::class], version = 1)
abstract class tpredatabse : RoomDatabase() {
    abstract fun getdata() : tpreDao
}