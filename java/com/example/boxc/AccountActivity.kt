package com.example.boxc

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boxc.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {
    lateinit var b :  ActivityAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b =  ActivityAccountBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.back.setOnClickListener {
            finish()
        }
        val sharedp: SharedPreferences = getSharedPreferences("wallet", Context.MODE_PRIVATE)
        val value: String? = sharedp.getString("w", null)

        if(value == null){
            b.cash.text =  "$500"
        }else{
            b.cash.text = "$"+value
        }


    }
}