package com.example.githubrepo_livedata.data

import com.example.githubrepo_livedata.Network.ApiEndPoint
import com.example.githubrepo_livedata.Network.RetrofitClient
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import retrofit2.Response

class GithubRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    suspend fun getAllRepository(query : String) = retrofit.getAllRepo(query)

    suspend fun getAll() = retrofit.getAll()
}