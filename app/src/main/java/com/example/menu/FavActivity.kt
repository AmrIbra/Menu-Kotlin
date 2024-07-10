package com.example.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FavActivity:AppCompatActivity() {

    val mealDao=MealDatabase.getInstance(context = this).mealDao()

    val fav_data=mealDao.getAll().toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerView2)
        recyclerView.adapter=FavAdapter(fav_data, this)
        recyclerView.layoutManager= LinearLayoutManager(this)

    }
}