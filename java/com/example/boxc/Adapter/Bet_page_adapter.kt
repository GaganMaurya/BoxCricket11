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
import com.example.boxc.LeaderPage
import com.example.boxc.Models.Data
import com.example.boxc.Models.datamodel
import com.example.boxc.R
import com.example.boxc.databinding.BetPageRvBinding
import com.example.boxc.databinding.HomeRvContainerBinding
import com.example.boxc.model.bet_page_data
import com.example.boxc.model.demostring

class bet_page_adapter(var c : Context, var list  : List<bet_page_data>) : Adapter<bet_page_adapter.viehold>() {
    inner class viehold(view : View) : ViewHolder(view){
      var b  = BetPageRvBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viehold {
     var v =  LayoutInflater.from(c).inflate(R.layout.bet_page_rv , parent , false)
        return  viehold(v)
    }
//   fun getimage(s: String , v : String):ArrayList<demostring>{
//       var teamimage1 = s
//       var teamimage2 = v
//       val list = ArrayList<demostring>()
//       list.add(demostring(teamimage1 , teamimage2))
//       return list
//
//   }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viehold, position: Int) {
        var i = list[position]
        holder.b.tittle.text = "Winners: "+i.winner.toString()
        holder.b.time.text = i.tprice.toString()
        holder.b.mega.text = "$"+i.price.toString()
        holder.b.price.text = i.sleft.toString()
        holder.b.price2.text = i.sleft.toString()
        holder.b.ff.text = i.fprize.toString()
        holder.b.ffd.text = i.mbox.toString()


        holder.itemView.setOnClickListener{
            val intent =  Intent(c , LeaderPage::class.java)
            intent.putExtra("price" , i.price.toString())
            intent.putExtra("tprice" , i.tprice.toString())
            intent.putExtra("teamname1" , i.t1.toString())
            intent.putExtra("teamname2" , i.t2.toString())
            intent.putExtra("t1" , i.t3.toString())
            intent.putExtra("t2" , i.t4.toString())
            c.startActivity(intent)
            Animatoo.animateSlideLeft(c)
    }


    }
}