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

class bat : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bat, container, false)
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


            if (myApp.player5) {
                if(userDao.getAll().size<=8) {
                    btn.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 5", number =  "5"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }

            } else {
                btn.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "5")

            }

            myApp.player5 = !myApp.player5
        }

        btn1.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player6) {
                if(userDao.getAll().size<=8) {
                    btn1.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 6", number =  "6"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }



            } else {
                btn1.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "6")

            }

            myApp.player6 = !myApp.player6

        }
        btn2.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player7) {
                if(userDao.getAll().size<=8) {
                    btn2.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 7", number =  "7"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }

            } else {
                btn2.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "7")

            }

            myApp.player7 = !myApp.player7

        }

        btn3.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            val userDao = db.userDao()

            if (myApp.player8) {
                if(userDao.getAll().size<=8) {
                    btn3.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 8", number =  "8"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn3.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "8")

            }

            myApp.player8 = !myApp.player8

        }
        btn4.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player9) {
                if(userDao.getAll().size<=8) {
                    btn4.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 9", number =  "9"))
                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn4.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete("9")

            }

            myApp.player9 = !myApp.player9

        }

    }


}