package com.example.boxc.Fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContentProviderCompat.requireContext
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.LoginPage
import com.example.boxc.R
import com.example.boxc.databinding.FragmentSettingsBinding

class Settings : Fragment() {
    lateinit var filepath: Uri
    lateinit var profileimage: ImageView
    lateinit var ip: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val b =  FragmentSettingsBinding.inflate(inflater, container, false)
         ip = registerForActivityResult(ActivityResultContracts.GetContent())
        {
            filepath = it!!
            profileimage.setImageURI(it)
        }
        profileimage = b.userimage
        profileimage.setOnClickListener {
            editphoto()
        }
//$500 \n Total Balance
        val sharedp: SharedPreferences = activity?.getSharedPreferences("wallet", Context.MODE_PRIVATE)!!
        val value: String? = sharedp.getString("w", null)

        if(value == null){
            b.price.text =  "$500 \n Total Balance"
        }else{
            b.price.text = "$"+value+" \n Total Balance"
        }

        val sdd: SharedPreferences = this.requireActivity().getSharedPreferences("hello", Context.MODE_PRIVATE)
        val vv: String? = sdd.getString("key2", null)
        b.username.text = vv


        b.demo3.setOnClickListener {
            val d = AlertDialog.Builder(requireContext())
            d.setTitle("LogOut!")
            d.setMessage("Are you sure you want to logout?")
            d.setCancelable(true)
            d.setPositiveButton("Yes") { it, which ->
                val sharedp: SharedPreferences = activity?.getSharedPreferences("hello", Context.MODE_PRIVATE)!!
                val editor: SharedPreferences.Editor = sharedp.edit()
                editor.apply {

                    putString("key1", "0")


                }.apply()
                startActivity(Intent(requireContext(), LoginPage::class.java))
                Animatoo.animateSlideLeft(requireContext())

            }
            d.setNegativeButton("No") { it, which ->
               it.cancel()

            }
            d.create().show()


        }
        return b.root
    }

    private fun editphoto() {



        val d = AlertDialog.Builder(requireContext())
        d.setTitle("Update Image")
        d.setMessage("Pick image from")
        d.setCancelable(true)
        d.setPositiveButton("Camera") { it, which ->
            val camera_intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            } else {
                TODO("VERSION.SDK_INT < CUPCAKE")
            }
            startActivityForResult(camera_intent, 1)


        }
        d.setNegativeButton("Storage") { it, which ->
            ip.launch("image/*")

        }
        d.create().show()

    }


override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    if (requestCode == 1) {

        val photo = data!!.extras!!["data"] as Bitmap?

         profileimage.setImageBitmap(photo)


    }
}
}