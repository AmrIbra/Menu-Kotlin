package com.example.menu

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity :AppCompatActivity() {

    //lateinit var buttonAdd: Button

    val data=arrayListOf<MealClass>(
        MealClass(R.drawable.burger, "Burger"),
        MealClass(R.drawable.frenchfries, "French Fries"),
        MealClass(R.drawable.kebab, "Kebab"),
        MealClass(R.drawable.pane, "Chicken Pane"),
        MealClass(R.drawable.pizza, "Pizza"),
        MealClass(R.drawable.shawerma, "Shawerma"),
        MealClass(R.drawable.spaghetti, "Spaghetti"),)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val recyclerView: RecyclerView =findViewById(R.id.recyclerView)
        recyclerView.adapter=MealAdapter(data, this)
        recyclerView.layoutManager= LinearLayoutManager(this)



    }
}