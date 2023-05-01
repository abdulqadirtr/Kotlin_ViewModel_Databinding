package com.example.githubrepo_livedata.Network

import com.example.githubrepo_livedata.data.model.GithubResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {
    @GET("search/repositories")
    fun getAllRepo(@Query("q") q : String) : Call<GithubResponseModel>
}