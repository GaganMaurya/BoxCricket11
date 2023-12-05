package com.example.boxc.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.boxc.R
import com.example.boxc.databinding.DemorvBinding
import com.example.boxc.model.rvdata
import com.example.boxc.room.roomdataclass
import com.example.boxc.room2.dataclass


class rvadspter(var c : Context, var list :  List<dataclass>)  : RecyclerView.Adapter<rvadspter.viewholder>(){
    inner class viewholder(v : View) :  ViewHolder(v){
        var b :  DemorvBinding = DemorvBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
       return viewholder(LayoutInflater.from(c).inflate(R.layout.demorv,parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var i =  list[position]
        holder.b.id.text = i.uid.toString()
        holder.b.name.text = i.name
        holder.b.number.text = i.number
    }
}