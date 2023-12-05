package com.example.boxc.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class roomdataclass(

    @PrimaryKey(autoGenerate = true)
    val uid: Int =0 ,
    @ColumnInfo(name = "first_name") val name: String?,
    @ColumnInfo(name = "number") val number: String?

)
