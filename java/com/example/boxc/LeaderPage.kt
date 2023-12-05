package com.example.boxc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.databinding.ActivityLeaderPageBinding

class LeaderPage : AppCompatActivity() {
    lateinit var b : ActivityLeaderPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityLeaderPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)
       b.back.setOnClickListener {
           finish()
           Animatoo.animateSlideRight(this)
       }

        var tprice =  intent.getStringExtra("tprice").toString()
        var price =  intent.getStringExtra("price").toString()
        var teamname1 =  intent.getStringExtra("teamname1").toString()
        var teamname2 =  intent.getStringExtra("teamname2").toString()
        var t1 =  intent.getStringExtra("t1").toString()
        var t2 =  intent.getStringExtra("t2").toString()
        b.time.text = tprice
        b.mega.text = "$"+price

        b.create.setOnClickListener {
          val intent = Intent(this , CreateTeam::class.java)
            intent.putExtra("teamimage1" , teamname1)
            intent.putExtra("teamimage2" , teamname2)
            intent.putExtra("t1" , t1)
            intent.putExtra("t2" , t2)
            intent.putExtra("pr" , price)

            startActivity(intent)
            Animatoo.animateSlideLeft(this)
        }

    }
}