package com.example.boxc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.databinding.ActivityTeamPreviewBinding
import com.example.boxc.room.roomdatabs
import com.example.boxc.room2.dataabs
import com.example.boxc.room3.tpredatabse

class TeamPreview : AppCompatActivity() {
    lateinit var b : ActivityTeamPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b =  ActivityTeamPreviewBinding.inflate(layoutInflater)
        setTheme(R.style.boxtheme)
        setContentView(b.root)


        b.back.setOnClickListener {
            finish()
            Animatoo.animateSlideRight(this)
        }


        val db = Room.databaseBuilder(
            this,
            tpredatabse::class.java, "tprevdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        val ud = db.getdata()

        val list = ud.getAll()

       // val gd = list.chunked(9)



//        b.rv.layoutManager = LinearLayoutManager(this)
//        var adapter = rvadspter(this , list)
//        b.rv.adapter = adapter

        if (list.any{it.number == "1"}){
            b.p1.visibility = View.VISIBLE
        }
        if (list.any { it.number == "2" }){
            b.p2.visibility = View.VISIBLE
        }
        if (list.any { it.number == "3" }){
            b.p3.visibility = View.VISIBLE
        }
        if (list.any { it.number == "4" }){
            b.p4.visibility = View.VISIBLE
        }
        if (list.any { it.number == "5" }){
            b.p5.visibility = View.VISIBLE
        }

        if (list.any{it.number == "6"}){
            b.p6.visibility = View.VISIBLE
        }
        if (list.any { it.number == "7" }){
            b.p7.visibility = View.VISIBLE
        }
        if (list.any { it.number == "8" }){
            b.p8.visibility = View.VISIBLE
        }
        if (list.any { it.number == "9" }){
            b.p9.visibility = View.VISIBLE
        }
        if (list.any { it.number == "10" }){
            b.p10.visibility = View.VISIBLE
        }
        if (list.any{it.number == "11"}){
            b.p11.visibility = View.VISIBLE
        }
        if (list.any { it.number == "12" }){
            b.p12.visibility = View.VISIBLE
        }
        if (list.any { it.number == "13" }){
            b.p13.visibility = View.VISIBLE
        }
        if (list.any { it.number == "14" }){
            b.p14.visibility = View.VISIBLE
        }
        if (list.any { it.number == "15" }){
            b.p15.visibility = View.VISIBLE
        }

        if (list.any{it.number == "16"}){
            b.p16.visibility = View.VISIBLE
        }
        if (list.any { it.number == "17" }){
            b.p17.visibility = View.VISIBLE
        }
        if (list.any { it.number == "18" }){
            b.p18.visibility = View.VISIBLE
        }
        if (list.any { it.number == "19" }){
            b.p19.visibility = View.VISIBLE
        }
        if (list.any { it.number == "20" }){
            b.p20.visibility = View.VISIBLE
        }

    }

}