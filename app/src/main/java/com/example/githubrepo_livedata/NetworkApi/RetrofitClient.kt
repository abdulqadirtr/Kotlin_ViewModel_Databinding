package com.example.githubrepo_livedata.NetworkApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Appendable

class RetrofitClient {

    companion object{

        val baseUrl = "https://api.github.com/"

        fun getRetrofitInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}