package com.example.menu

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("meals") var meals: ArrayList<Meals> = arrayListOf()
)