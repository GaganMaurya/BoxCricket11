package com.example.boxc

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.Adapter.rvadspter
import com.example.boxc.databinding.ActivityBoxBinding
import com.example.boxc.model.rvdata
import com.example.boxc.room.roomdatabs
import com.example.boxc.room.roomdataclass
import com.example.boxc.room2.dataDao
import com.example.boxc.room2.dataabs
import com.example.boxc.room2.dataclass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Box : AppCompatActivity() {
    lateinit var b:ActivityBoxBinding
    lateinit var datalist: List<roomdataclass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityBoxBinding.inflate(layoutInflater)
        setTheme(R.style.boxtheme)
        setContentView(b.root)

        b.back.setOnClickListener {
            finish()
            Animatoo.animateSlideRight(this)
        }

        var pr =  intent.getStringExtra("pr").toString()

        val db = Room.databaseBuilder(
            this,
            roomdatabs::class.java, "roomdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val userDao = db.userDao()
        val list  =userDao.getAll()
        datalist = list

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

       if(list.size == 9){
           b.btn.visibility = View.VISIBLE
       }

     b.btn.setOnClickListener {
         var dialog = Dialog(this)
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
         var a = LayoutInflater.from(this).inflate(R.layout.bottom_sheet , null)

         dialog.setContentView(a)

         var cross  =  a.findViewById<ImageView>(R.id.cross)
         var price  =  a.findViewById<TextView>(R.id.price)
         price.text = "$"+pr

         cross.setOnClickListener {
             dialog.dismiss()
         }

         var tprice  =  a.findViewById<TextView>(R.id.tprice)
         tprice.text = "$"+pr



         var joinbtn  =  a.findViewById<Button>(R.id.join)
         joinbtn.setOnClickListener {

           val am =  pr

             val sd: SharedPreferences = getSharedPreferences("wallet", Context.MODE_PRIVATE)
             val v: String? = sd.getString("w", null)
             var value =0

             if(v == null){
                  value = 500 - am.toInt()
             }else{
                  value = v.toString().toInt()  - am.toInt()
             }


             val sharedp: SharedPreferences = getSharedPreferences("wallet", Context.MODE_PRIVATE)
             val editor: SharedPreferences.Editor = sharedp.edit()
             editor.apply {

                 putString("w", value.toString())
             }.apply()

try {
    val db = Room.databaseBuilder(
        this,
        dataabs::class.java, "dataclass"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    val userDao = db.ud()


   for(i in datalist){
       val newdata = dataclass( name = i.name, number = i.number )
       userDao.insert(newdata)
   }




}catch (e:Exception){
    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
}


             showCustomDialog()
             dialog.dismiss()
             val handler = Handler()
             handler.postDelayed({

                 startActivity(Intent(this, MainActivity::class.java))
                 Animatoo.animateSwipeLeft(this)
                 Toast.makeText(this, "Team created!", Toast.LENGTH_SHORT).show()
             },4000)

     }


         dialog.show()
         dialog.window?.setLayout(
             ViewGroup.LayoutParams.MATCH_PARENT,
             ViewGroup.LayoutParams.WRAP_CONTENT
         )
         dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
         dialog.window?.setGravity(Gravity.BOTTOM)
    }


}

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog_layout)
        dialog.setCancelable(false)


        dialog.show()

        val handler = Handler()
        handler.postDelayed({
            dialog.dismiss()
        }, 10000)
    }
}