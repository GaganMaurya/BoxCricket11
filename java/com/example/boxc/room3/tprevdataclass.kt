package com.example.boxc.room3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class tprevdataclass(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val name: String?,
    @ColumnInfo(name = "number") val number: String?
)