package com.example.menu

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonM: Button
    lateinit var buttonF: Button
    lateinit var buttonR: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonM=findViewById(R.id.buttonMenu)
        buttonM.setOnClickListener({
            val intentM = Intent(this, MenuActivity::class.java)
            startActivity(intentM)
        })

        buttonF=findViewById(R.id.buttonFav)
        buttonF.setOnClickListener({
            val intentF = Intent(this, FavActivity::class.java)
            startActivity(intentF)
        })

        buttonR=findViewById(R.id.buttonRandom)
        buttonR.setOnClickListener({
            val intentR = Intent(this, RandomActivity::class.java)
            startActivity(intentR)
        })

    }

    override fun onStart() {
        super.onStart()
    }


}