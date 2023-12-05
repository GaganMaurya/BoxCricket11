package com.example.boxc

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.Adapter.Dbhelper
import com.example.boxc.databinding.ActivityMain2Binding

class LoginPage : AppCompatActivity() {
    lateinit var b : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(b.root)

        val db =  Dbhelper(this , null)
        val cursor = db.getName()

        cursor!!.moveToFirst()
        val email =  cursor.getString(cursor.getColumnIndex(Dbhelper.EMAIL)).toString()
        val pass = cursor.getString(cursor.getColumnIndex(Dbhelper.Pass)).toString()

        Toast.makeText(this, email+"&" +pass ,Toast.LENGTH_SHORT).show()

        b.btn.setOnClickListener {
            if(b.pass.text!!.isNotEmpty() &&  b.email.text!!.isNotEmpty()){


                if(b.email.text.toString() == email&&
                b.pass.text.toString() == pass){
                    val sharedp: SharedPreferences = this.getSharedPreferences("hello", Context.MODE_PRIVATE)!!
                    val editor: SharedPreferences.Editor = sharedp.edit()
                    editor.apply {

                        putString("key1", "1")


                    }.apply()
                    Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this , MainActivity::class.java))
                     Animatoo.animateFade(this);
                }
                 else{
                    Toast.makeText(this, "data does not match try again", Toast.LENGTH_SHORT).show()
                }

//
            }


        }
    }
}