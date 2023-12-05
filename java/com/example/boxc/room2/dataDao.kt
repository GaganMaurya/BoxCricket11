package com.example.boxc.room2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.boxc.R
import com.example.boxc.room.roomdataclass

@Dao
interface dataDao  {

    @Query("SELECT * FROM dataclass")
    fun getAll(): List<dataclass>



    @Insert
     fun insert( users: dataclass)

    @Query("DELETE FROM dataclass WHERE number = :item")
    fun delete(item : String )
}