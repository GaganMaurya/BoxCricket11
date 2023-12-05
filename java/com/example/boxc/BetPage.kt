package com.example.boxc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.Adapter.bet_page_adapter
import com.example.boxc.databinding.ActivityBetPageBinding
import com.example.boxc.databinding.BetPageRvBinding
import com.example.boxc.model.bet_page_data

class BetPage : AppCompatActivity() {
    lateinit var b :  ActivityBetPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityBetPageBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.back.setOnClickListener {
            finish()
            Animatoo.animateSlideRight(this)
        }

        var team1 = intent.getStringExtra("team1").toString()
        var team2 = intent.getStringExtra("team2").toString()
        var teammage1 = intent.getStringExtra("teamimage1").toString()
        var teamimage2 = intent.getStringExtra("teamimage2").toString()




        b.toolbarteam.text = team1+" vs "+team2

        b.betPageRv.layoutManager = LinearLayoutManager(this)
        var list  =  ArrayList<bet_page_data>()
        list.add(bet_page_data("123456" , "15 lakh" , "29" , "123450 Spots left" , "500000 Spots " ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "10 lakh" , "29" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "5 lakh" , "19" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "1 lakh" , "90" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "50 lakh" , "19" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "25 lakh" , "119" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "10 hazar" , "229" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "15 hazar" , "293" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "1.5 lakh" , "294" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "2.5 lakh" , "291" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "11 lakh" , "292" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "23 lakh" , "298" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "16 lakh" , "292" , "123450 Spots left"  , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))
        list.add(bet_page_data("123456" , "14 lakh" , "291" , "123450 Spots left" , "500000 Spots" ,"1st Price: $10000" , "Max Boxes: 20",teammage1,teamimage2,team1,team2))

        var adapter =  bet_page_adapter(this , list)
        b.betPageRv.adapter = adapter

    }
}