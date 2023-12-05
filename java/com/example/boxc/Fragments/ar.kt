package com.example.boxc.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.example.boxc.R
import com.example.boxc.model.MyApplication
import com.example.boxc.room.roomdatabs
import com.example.boxc.room.roomdataclass

class ar : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<View>(R.id.p1c)
        val btn1 = view.findViewById<View>(R.id.p2c)
        val btn2 = view.findViewById<View>(R.id.p3c)
        val btn3 = view.findViewById<View>(R.id.p4c)
        val btn4 = view.findViewById<View>(R.id.p5c)

        val db = Room.databaseBuilder(
            requireContext(),
            roomdatabs::class.java, "roomdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val userDao = db.userDao()

        btn.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player10) {
                if(userDao.getAll().size<=8) {
                    btn.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 10", number =  "10"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete("10")

            }

            myApp.player10 = !myApp.player10
        }

        btn1.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player11) {
                if(userDao.getAll().size<=8) {
                    btn1.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 11", number = "11"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn1.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete("11")

            }

            myApp.player11 = !myApp.player11

        }
        btn2.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player12) {
                if(userDao.getAll().size<=8) {
                    btn2.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 12", number = "12"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn2.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete(  "12")

            }

            myApp.player12 = !myApp.player12

        }

        btn3.setOnClickListener {
            val myApp = requireActivity().application as MyApplication




            if (myApp.player13) {
                if(userDao.getAll().size<=8) {
                    btn3.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 13", number = "13"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }



            } else {
                btn3.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete("13")

            }

            myApp.player13 = !myApp.player13

        }
        btn4.setOnClickListener {
            val myApp = requireActivity().application as MyApplication




            if (myApp.player14) {
                    if(userDao.getAll().size<=8) {
                        btn4.setBackgroundResource(R.drawable.green_fill)
                        userDao.insert(roomdataclass(name =  "player 14", number =  "14"))
                    }else{
                        Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                    }


            } else {
                btn4.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete(  "14")

            }

            myApp.player14 = !myApp.player14

        }

    }
}