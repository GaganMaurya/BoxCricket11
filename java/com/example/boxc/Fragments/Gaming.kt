package com.example.boxc.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.boxc.Crciket
import com.example.boxc.R
import com.example.boxc.databinding.FragmentGamingBinding

class Gaming : Fragment() {
   lateinit var b :  FragmentGamingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var b=  FragmentGamingBinding.inflate(inflater, container, false)
        b.playbtn.setOnClickListener {
            startActivity(Intent(requireContext(), Crciket::class.java))
        }

        return b.root
    }

 }

