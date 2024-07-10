package com.example.menu

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface MealDao {
    @Query("SELECT * FROM meals")
     fun getAll(): Array<MealClass>

    @Query("SELECT * FROM meals WHERE name=:name")
    suspend fun getMealByName(name:String):List<MealClass>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(vararg meal:MealClass):List<Long>
    @Update
    fun update(meal:MealClass)

    @Delete
    fun delete(meal:MealClass):Int
}