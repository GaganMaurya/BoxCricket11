package com.example.boxc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.bumptech.glide.Glide
import com.example.boxc.Adapter.ViewpagerAdapter
import com.example.boxc.Fragments.ar
import com.example.boxc.Fragments.bat
import com.example.boxc.Fragments.bowl
import com.example.boxc.Fragments.wk
import com.example.boxc.databinding.ActivityCreateTeamBinding
import com.example.boxc.room.roomdatabs

class CreateTeam : AppCompatActivity() {
    lateinit var b :  ActivityCreateTeamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityCreateTeamBinding.inflate(layoutInflater)
        setTheme(R.style.boxtheme)
        setContentView(b.root)
        b.back.setOnClickListener {
            finish()
            Animatoo.animateSlideRight(this)
        }

        val db = Room.databaseBuilder(
            this,
            roomdatabs::class.java, "roomdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val userDao = db.userDao()
        val list = userDao.getAll()
        for (i in list) {
            userDao.delete(i.number!!)
        }

        var teamname1 =  intent.getStringExtra("teamimage1").toString()
        var teamname2 =  intent.getStringExtra("teamimage2").toString()
        var t1 =  intent.getStringExtra("t1").toString()
        var t2 =  intent.getStringExtra("t2").toString()
        var pr =  intent.getStringExtra("pr").toString()

        b.teamn1.text =t1
        b.teamn2.text = t2
        Glide.with(this).load(teamname1).placeholder(R.drawable.micronesia).into(b.teami2)
        Glide.with(this).load(teamname2).placeholder(R.drawable.micronesia).into(b.teami3)

        val fragmentArrayList = ArrayList<Fragment>()
        fragmentArrayList.add(wk())
        fragmentArrayList.add(bat())
        fragmentArrayList.add(ar())
        fragmentArrayList.add(bowl())

        val adapter = ViewpagerAdapter(this, supportFragmentManager, fragmentArrayList)
        b.mainViewPager.adapter = adapter
        b.tablayout.setupWithViewPager(b.mainViewPager)

        b.showbox.setOnClickListener {
            var i = Intent(this, Box::class.java)
            i.putExtra("pr" ,pr)
            startActivity(i)
            Animatoo.animateSlideLeft(this)
        }

    }
}