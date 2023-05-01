package com.example.githubrepo_livedata.data

import com.example.githubrepo_livedata.Network.ApiEndPoint
import com.example.githubrepo_livedata.Network.RetrofitClient

class GithubRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    fun getAllRepository(query : String) = retrofit.getAllRepo(query)
}