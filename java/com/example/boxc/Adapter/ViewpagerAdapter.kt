package com.example.boxc.Adapter

import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import androidx.fragment.app.FragmentPagerAdapter

class ViewpagerAdapter (private val context : Context, fm : androidx.fragment.app.FragmentManager?, val list : ArrayList<androidx.fragment.app.Fragment>) : FragmentPagerAdapter(fm!!) {
    val tab_titles = arrayOf("WK" , "BAT" , "AR","BOWL")

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tab_titles[position]
    }


}