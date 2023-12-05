package com.example.boxc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.boxc.Models.datamodel
import com.example.boxc.databinding.ActivityMainBinding
import com.example.boxc.retrofitModel.apiinterface
import com.example.boxc.retrofitModel.constant.api_key
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.homeTheme)
        setContentView(b.root)

        b.bottomNavigationView.background = null

        var navcontr = findNavController(R.id.fragmentContainerView)
        b.bottomNavigationView.setupWithNavController(navcontr)



    }
}