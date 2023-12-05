package com.example.boxc.room3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.boxc.room2.dataclass

@Dao
interface tpreDao {

    @Query("SELECT * FROM tprevdataclass")
    fun getAll(): List<tprevdataclass>



    @Insert
    fun insert( users: tprevdataclass)

    @Query("DELETE FROM tprevdataclass WHERE number = :item")
    fun delete(item : String)
}