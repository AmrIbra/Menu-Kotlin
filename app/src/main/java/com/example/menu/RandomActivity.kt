package com.example.menu

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomActivity : AppCompatActivity() {

private val TAG="RandomActivity"
lateinit var mealName:TextView
lateinit var thumbnail:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random)
        mealName=findViewById(R.id.RandomTextView)
        thumbnail=findViewById(R.id.RandomImageView)

        val service=APIClient.retrofitService
        service.getRandomMeal().enqueue(object : Callback<Meal> {
            override fun onResponse(call: Call<Meal>, response: Response<Meal>) {
                if(response.isSuccessful){
                    val randomMeal=response.body()?.meals
                    println(randomMeal)
                    mealName.text=randomMeal?.get(0)?.strMeal

                    Glide.with(this@RandomActivity)
                        .load(randomMeal?.get(0)?.strMealThumb)
                        .into(thumbnail)
                }
            }

            override fun onFailure(call: Call<Meal>, response: Throwable) {
                Log.i(TAG,"onFailure: ${response.cause}")
            }

        })


    }
}