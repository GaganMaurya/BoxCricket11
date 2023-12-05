package com.example.boxc.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.boxc.AccountActivity
import com.example.boxc.Adapter.main_page_adapter
import com.example.boxc.Models.Data
import com.example.boxc.Models.datamodel
import  com.example.boxc.R
import com.example.boxc.databinding.FragmentHomeBinding
import com.example.boxc.retrofitModel.apiinterface
import com.example.boxc.retrofitModel.constant
import retrofit2.Call
import retrofit2.Response

class home : Fragment() {
    var id = "1"
    lateinit var recyclerView: RecyclerView
    lateinit var b : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         b = FragmentHomeBinding.inflate(inflater)

        b.userimage.setOnClickListener{
            startActivity(Intent(requireContext() , AccountActivity::class.java))
            Animatoo.animateSlideUp(requireContext())
        }



        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        val sharedp: SharedPreferences = this.requireActivity().getSharedPreferences("hello", Context.MODE_PRIVATE)
        val value: String? = sharedp.getString("key2", null)
        val name = view.findViewById<TextView>(R.id.username)
        name.text = value.toString()

        val wallet = view.findViewById<ImageView>(R.id.wallet)

        wallet.setOnClickListener {
          startActivity(Intent(requireContext(), AccountActivity::class.java))
            Animatoo.animateSlideUp(requireContext())
        }

        b.simmer.startShimmer()
        getdata()



    }
    private fun getdata() {
        recyclerView = view?.findViewById(com.example.boxc.R.id.main_page_rv)!!
        recyclerView.layoutManager =  LinearLayoutManager(requireContext())

        val da = apiinterface.feeservice.retrofitinstace.getdata(constant.api_key,id)
        da.enqueue(object : retrofit2.Callback<datamodel>{
            override fun onResponse(call: Call<datamodel>, response: Response<datamodel>) {
                val databody = response.body()
                if(databody?.data != null){
                       val adapter = main_page_adapter(requireContext(), databody.data)
                       recyclerView.adapter = adapter
                    recyclerView.visibility = View.VISIBLE
                    b.simmer.stopShimmer()
                    b.simmer.visibility =  View.GONE

                }else{
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
                    b.simmer.stopShimmer()
                    b.simmer.visibility =  View.GONE
                }
            }

            override fun onFailure(call: Call<datamodel>, t: Throwable) {
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}