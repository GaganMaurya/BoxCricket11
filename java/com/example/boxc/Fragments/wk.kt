package com.example.boxc.Fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.boxc.R
import com.example.boxc.databinding.FragmentWkBinding
import com.example.boxc.model.MyApplication
import com.example.boxc.room.roomdatabs
import com.example.boxc.room.roomdataclass

class wk : Fragment() {
  lateinit var b :  FragmentWkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        b = FragmentWkBinding.inflate(layoutInflater)
        super.onViewCreated(view, savedInstanceState)
        val db = Room.databaseBuilder(
            requireContext(),
            roomdatabs::class.java, "roomdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val userDao = db.userDao()





       val btn = view.findViewById<View>(R.id.p1c)
       val btn1 = view.findViewById<View>(R.id.p2c)
       val btn2 = view.findViewById<View>(R.id.p3c)
       val btn3 = view.findViewById<View>(R.id.p4c)

       val p = view.findViewById<TextView>(R.id.player1points)

        p.setOnClickListener {
        val list = userDao.getAll()
        for (i in list) {
            userDao.delete(i.number!!)
        }
        }


            btn.setOnClickListener {
                val myApp = requireActivity().application as MyApplication


                if (myApp.player1) {

                    if(userDao.getAll().size<=8) {
                        btn.setBackgroundResource(R.drawable.green_fill)
                        userDao.insert(roomdataclass(name = "player 1", number = "1"))
                    }else{
                        Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                    }

                } else {
                    btn.setBackgroundResource(R.drawable.red_outlin)
                    userDao.delete("1")

                }

                myApp.player1 = !myApp.player1
            }
        btn1.setOnClickListener {
            val myApp = requireActivity().application as MyApplication


            if (myApp.player2) {

                if(userDao.getAll().size<=8) {
                    btn1.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 2", number = "2"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn1.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "2")

            }

            myApp.player2 = !myApp.player2
        }
        btn2.setOnClickListener {
            val myApp = requireActivity().application as MyApplication




            if (myApp.player3) {

                if(userDao.getAll().size<=8) {
                    btn2.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name="player 3",number = "3"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn2.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "3")
            }

            myApp.player3 = !myApp.player3
        }
        btn3.setOnClickListener {
            val myApp = requireActivity().application as MyApplication

            if (myApp.player4) {

                if(userDao.getAll().size<=8) {
                    btn3.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name="player 4",number = "4"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn3.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "4")

            }

            myApp.player4 = !myApp.player4
        }




// fun btn(btn :  View,s: String){
//     Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show()
//
//
//     val sharedp: SharedPreferences = requireActivity().getSharedPreferences("h", Context.MODE_PRIVATE)
//     var value: String? = sharedp.getString("k", null)
//
//     if(value== "1"){
//         btn.setBackgroundResource(R.drawable.green_fill)
//
//         val list = roomdataclass(1,s,"1")
//         userDao.insert(list)
//         Toast.makeText(requireContext(), "data added", Toast.LENGTH_SHORT).show()
//
//         value = "0"
//         val sharedp: SharedPreferences = requireActivity().getSharedPreferences("h", Context.MODE_PRIVATE)
//         val editor: SharedPreferences.Editor = sharedp.edit()
//         editor.apply {
//
//             putString("k", value)
//
//
//         }.apply()
//     }else {
//         btn.setBackgroundResource(R.drawable.red_outlin)
//         val list = roomdataclass(1,s,  "1")
//         userDao.delete(list)
//         Toast.makeText(requireContext(), "datadeleted", Toast.LENGTH_SHORT).show()
//
//         value = "1"
//         val sharedp: SharedPreferences = requireActivity().getSharedPreferences("h", Context.MODE_PRIVATE)
//         val editor: SharedPreferences.Editor = sharedp.edit()
//         editor.apply {
//
//             putString("k", value)
//
//
//         }.apply()
//     }
// }
//
//


    }

}