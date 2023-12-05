package com.example.boxc.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.bumptech.glide.Glide
import com.example.boxc.BetPage
import com.example.boxc.Models.Data
import com.example.boxc.Models.datamodel
import com.example.boxc.R
import com.example.boxc.databinding.HomeRvContainerBinding

class main_page_adapter(var c : Context, var list  : List<Data>) : Adapter<main_page_adapter.viehold>() {
    inner class viehold(view : View) : ViewHolder(view){
      var b  = HomeRvContainerBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viehold {
     var v =  LayoutInflater.from(c).inflate(R.layout.home_rv_container , parent , false)
        return  viehold(v)

    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: viehold, position: Int) {
         var i = list[position]
         holder.b.tittle.text = i.name.toString()




            holder.b.teamname.text = i.teamInfo[0].shortname.toString()


            holder.b.teamname2.text = i.teamInfo[1].shortname.toString()

        holder.b.team1name.text = i.teamInfo[0].name.toString()

        holder.b.team2name.text = i.teamInfo[1].name.toString()

        holder.b.time.text = i.date.toString()
        Glide.with(c).load(i.teamInfo[0].img).placeholder(R.drawable.micronesia).into(holder.b.teamlogo)
        Glide.with(c).load(i.teamInfo[1].img).placeholder(R.drawable.micronesia).into(holder.b.teamlogo2)

        holder.itemView.setOnClickListener{
          val intent =  Intent(c , BetPage::class.java)
            intent.putExtra("team1" , i.teamInfo[0].shortname.toString())
            intent.putExtra("team2" , i.teamInfo[1].shortname.toString())
            intent.putExtra("team1name" , i.teamInfo[0].name.toString())
            intent.putExtra("team2name" , i.teamInfo[1].name.toString())
            intent.putExtra("teamimage1" , i.teamInfo[0].img.toString())
            intent.putExtra("teamimage2" , i.teamInfo[1].img.toString())
            c.startActivity(intent)
            Animatoo.animateSlideLeft(c)
        }

    }
}