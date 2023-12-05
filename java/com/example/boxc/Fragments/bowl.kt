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

class bowl : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bowl, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = view.findViewById<View>(R.id.p1c)
        val btn1 = view.findViewById<View>(R.id.p2c)
        val btn2 = view.findViewById<View>(R.id.p3c)
        val btn3 = view.findViewById<View>(R.id.p4c)
        val btn4 = view.findViewById<View>(R.id.p5c)
        val btn5 = view.findViewById<View>(R.id.p6c)

        val db = Room.databaseBuilder(
            requireContext(),
            roomdatabs::class.java, "roomdataclass"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        val userDao = db.userDao()

        btn.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player15) {
                if(userDao.getAll().size<=8) {
                    btn.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 15", number =  "15"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "15")

            }

            myApp.player15 = !myApp.player15
        }

        btn1.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player16) {
                if(userDao.getAll().size<=8) {
                    btn1.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 16", number = "16"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn1.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete("16")

            }

            myApp.player16 = !myApp.player16

        }
        btn2.setOnClickListener {
            val myApp = requireActivity().application as MyApplication



            if (myApp.player17) {
                if(userDao.getAll().size<=8) {
                    btn2.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 17", number =  "17"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn2.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete(  "17")

            }

            myApp.player17 = !myApp.player17

        }

        btn3.setOnClickListener {
            val myApp = requireActivity().application as MyApplication


            if (myApp.player18) {
                if(userDao.getAll().size<=8) {
                    btn3.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 18", number =  "18"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn3.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "18")

            }

            myApp.player18 = !myApp.player18

        }
        btn4.setOnClickListener {
            val myApp = requireActivity().application as MyApplication


            if (myApp.player19) {
                if(userDao.getAll().size<=8) {
                    btn4.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name =  "player 19", number =  "19"))


                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }

            } else {
                btn4.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete( "19")

            }

            myApp.player19 = !myApp.player19

        }
        btn5.setOnClickListener {
            val myApp = requireActivity().application as MyApplication


            if (myApp.player20) {
                if(userDao.getAll().size<=8) {
                    btn5.setBackgroundResource(R.drawable.green_fill)
                    userDao.insert(roomdataclass(name = "player 20", number = "20"))

                }else{
                    Toast.makeText(requireContext(), "Cannot add This Player \n Data limit exceeds", Toast.LENGTH_SHORT).show()
                }


            } else {
                btn5.setBackgroundResource(R.drawable.red_outlin)
                userDao.delete(  "20")

            }

            myApp.player20 = !myApp.player20

        }


    }
}