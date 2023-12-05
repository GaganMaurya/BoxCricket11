package com.example.boxc.room

import android.os.Build.VERSION_CODES.O
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.boxc.R

@Dao
interface roomDAO  {

    @Query("SELECT * FROM roomdataclass")
    fun getAll(): List<roomdataclass>

    @Query("DELETE FROM roomdataclass WHERE number = :item")
    fun delete(item : String)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( users: roomdataclass)




}