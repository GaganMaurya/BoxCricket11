package com.example.boxc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.boxc.Adapter.mymatcheradapter
import com.example.boxc.Adapter.rvadspter
import com.example.boxc.R
import com.example.boxc.databinding.FragmentLiveBinding
import com.example.boxc.room2.dataabs


class Live : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val b = FragmentLiveBinding.inflate(inflater, container, false)
        val db = Room.databaseBuilder(
            requireContext(),
            dataabs::class.java, "dataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

        val ud = db.ud()

        val list = ud.getAll()


       b.btn.setOnClickListener {
           for (i in list) {
               ud.delete(i.number!!)
           }

       }


        b.rv.layoutManager = LinearLayoutManager(requireContext())
        var adapter = rvadspter(requireContext() , list)
        b.rv.adapter = adapter



        return b.root
    }


}