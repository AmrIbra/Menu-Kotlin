package com.example.menu

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async


class FavActivity:AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)
        lifecycleScope.async {
            val mealDao=MealDatabase.getInstance(context =this@FavActivity).mealDao()

            withContext(Dispatchers.IO){
                val fav_data=mealDao.getAll().toList()
                val recyclerView: RecyclerView =findViewById(R.id.recyclerView2)
                recyclerView.adapter=FavAdapter(fav_data, this@FavActivity)
                recyclerView.layoutManager= LinearLayoutManager(this@FavActivity)
                //withContext(Dispatchers.Main){}
            }

        }


    }
}