package com.example.menu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealClass(
    @ColumnInfo(name = "meal") val img:Int,

    @PrimaryKey
    var name:String
)
