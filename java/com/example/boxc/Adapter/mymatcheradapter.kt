package com.example.boxc.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.room.Room
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.Box
import com.example.boxc.R
import com.example.boxc.TeamPreview
import com.example.boxc.databinding.DemorvBinding
import com.example.boxc.databinding.MymatchesLayoutBinding
import com.example.boxc.model.rvdata
import com.example.boxc.room.roomdataclass
import com.example.boxc.room2.dataDao
import com.example.boxc.room2.dataabs
import com.example.boxc.room2.dataclass
import com.example.boxc.room3.tpreDao
import com.example.boxc.room3.tpredatabse
import com.example.boxc.room3.tprevdataclass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class mymatcheradapter(var c : Context, var list :  List<List<dataclass>>)  : RecyclerView.Adapter<mymatcheradapter.viewholder>(){
    inner class viewholder(v : View) :  ViewHolder(v){
        var b  = MymatchesLayoutBinding.bind(v)
    }
    private lateinit var dataDao: tpreDao
    private lateinit var dataDao2: dataDao

    init {

        val db = Room.databaseBuilder(c, tpredatabse::class.java, "tprevdataclass").allowMainThreadQueries().fallbackToDestructiveMigration().build()
        dataDao = db.getdata()

        val db2 = Room.databaseBuilder(
            c,
            dataabs::class.java, "dataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        dataDao2 = db2.ud()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
       return viewholder(LayoutInflater.from(c).inflate(R.layout.mymatches_layout,parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var group =  list[position]

        holder.b.bn.text = "Box "+(position +1).toString()

       holder.b.preview.setOnClickListener{
           val l = dataDao.getAll()
           for (i in l) {
               dataDao.delete(i.number!!)
           }

           for (dataItem in group) {
               val dataEntity = tprevdataclass(name = dataItem.name.toString() , number = dataItem.number.toString())

                   dataDao.insert(dataEntity)

           }

           holder.b.delete.setOnClickListener {
               for (i in group) {

               }

             notifyDataSetChanged()
           }

           var i = Intent(c , TeamPreview::class.java)
           c.startActivity(i)
           Animatoo.animateSlideLeft(c)

       }


    }
}