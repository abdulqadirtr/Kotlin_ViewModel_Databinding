package com.example.githubrepo_livedata.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubrepo_livedata.Network.ApiEndPoint
import com.example.githubrepo_livedata.Network.RetrofitClient
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import kotlinx.coroutines.flow.Flow

class GithubRepository {
    private val retrofit = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)

    suspend fun getAllRepository(page : Int) = retrofit.getAllRepo(page)
}