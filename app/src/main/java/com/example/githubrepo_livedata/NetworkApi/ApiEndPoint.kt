package com.example.githubrepo_livedata.NetworkApi

import com.example.githubrepo_livedata.model.GithubResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {

    ///search/repositories?q=network
    @GET("search/repositories")
    fun getAllRepo(@Query("q") q : String) : Call<GithubResponseModel>
}