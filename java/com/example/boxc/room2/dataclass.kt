package com.example.boxc.room2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class dataclass(

    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val name: String?,
    @ColumnInfo(name = "number") val number: String?

)
