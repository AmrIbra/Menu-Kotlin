package com.example.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class FavActivity:AppCompatActivity() {

    val mealDao=MealDatabase.getInstance(context = this).mealDao()

    val fav_data=mealDao.getAll()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)

    }
}