package com.example.boxc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.boxc.Adapter.rvadspter
import com.example.boxc.R
import com.example.boxc.databinding.FragmentBellBinding
import com.example.boxc.room.roomdatabs
import com.example.boxc.room2.dataabs

class bell : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var b =  FragmentBellBinding.inflate(inflater, container, false)
//

        getfragment(MyMatches())

        b.upcoming.setOnClickListener{
            b.upcoming.setBackgroundResource(R.drawable.redbuttongradient)
            b.utext.setTextColor(resources.getColor(R.color.white))
            b.ltext.setTextColor(resources.getColor(R.color.black))
            b.mtext.setTextColor(resources.getColor(R.color.black))
            b.live.background = null
            b.mymatches.background = null
            getfragment(MyMatches())
        }
        b.live.setOnClickListener{
            b.live.setBackgroundResource(R.drawable.redbuttongradient)
            b.ltext.setTextColor(resources.getColor(R.color.white))
            b.utext.setTextColor(resources.getColor(R.color.black))
            b.mtext.setTextColor(resources.getColor(R.color.black))
            b.upcoming.background = null
            b.mymatches.background = null
//            for (i in list.indices) {
//                ud.delete(list[i])
//            }
            getfragment(Live())
        }
        b.mymatches.setOnClickListener{
            b.mymatches.setBackgroundResource(R.drawable.redbuttongradient)
            b.mtext.setTextColor(resources.getColor(R.color.white))
            b.utext.setTextColor(resources.getColor(R.color.black))
            b.ltext.setTextColor(resources.getColor(R.color.black))
            b.upcoming.background = null
            b.live.background = null
            getfragment(Completed())
        }




      return  b.root
    }
   fun getfragment(frag :  Fragment){
       val f = activity?.supportFragmentManager?.beginTransaction()
       f?.replace(R.id.framecontainer , frag)
       f?.addToBackStack(null)
       f?.commit()
   }


}