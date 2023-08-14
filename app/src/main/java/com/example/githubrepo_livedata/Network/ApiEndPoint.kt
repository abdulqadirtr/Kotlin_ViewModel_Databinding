package com.example.githubrepo_livedata.Network

import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {
    @GET("repositories")
   suspend fun getAllRepo(@Query("page") pager : Int) : Response<List<GithubRepositoryModel>>


}