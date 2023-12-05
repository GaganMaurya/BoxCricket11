package com.example.boxc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.boxc.databinding.ActivityCrciketBinding

class Crciket : AppCompatActivity() {
    lateinit var b : ActivityCrciketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b =  ActivityCrciketBinding.inflate(layoutInflater)

        setContentView(b.root)

        b.back.setOnClickListener {
            finish()
        }


        //val url = "https://maps.google.com/maps?q=loc:31.2232,75.7670"
        val url = "https://doodlecricket.github.io/#/"

        b.webView.settings.javaScriptEnabled = true

        b.webView.settings.userAgentString =
            "Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.5735.196 Mobile Safari/537.36"

        b.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {

                super.onPageFinished(view, url)
                b.progressBar.visibility = View.GONE
                b.webView.visibility = View.VISIBLE

            }


        }
        b.webView.loadUrl(url)

    }
}