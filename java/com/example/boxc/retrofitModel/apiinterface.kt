package com.example.boxc.retrofitModel

import com.example.boxc.Models.datamodel
import com.example.boxc.retrofitModel.constant.api_key
import com.example.boxc.retrofitModel.constant.baseurl
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface apiinterface {

    @GET("/v1/currentMatches")
    fun getdata(@Query("apikey") apikey : String ,@Query("offset") id : String) : Call<datamodel>

    object feeservice {

        val retrofitinstace  : apiinterface
        init {
            val retrofit = Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create()).build()

            retrofitinstace = retrofit.create(apiinterface::class.java)
        }
    }
}