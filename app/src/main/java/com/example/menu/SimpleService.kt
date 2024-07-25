package com.example.menu

import retrofit2.Call
import retrofit2.http.GET

interface SimpleService {
    @GET("random.php")
    fun getRandomMeal(): Call<Meal>
}