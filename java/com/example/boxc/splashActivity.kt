package com.example.boxc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class splashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        Handler(Looper.getMainLooper()).postDelayed({

                val sharedp: SharedPreferences = getSharedPreferences("hello", Context.MODE_PRIVATE)
                val value: String? = sharedp.getString("key1", null)
                if(value == null || value == "0"){
                    startActivity(Intent(this, RegistrationPage::class.java))
                    finish()

                }else{
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                }
        }, 3000)
    }
}