package com.example.githubrepo_livedata.data


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubrepo_livedata.Network.ApiEndPoint
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import retrofit2.HttpException
import java.io.IOException

class GithubPagingSource(private val api: ApiEndPoint) : PagingSource<Int, GithubRepositoryModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepositoryModel> {
        val position = params.key ?: 1

        return try {
            val response = api.getAllRepo()
            if (response.isSuccessful) {
                val data = response.body() ?: emptyList()
                val prevKey = if (position == 1) null else position - 1
                val nextKey = if (data.isEmpty()) null else position + 1
                LoadResult.Page(data, prevKey, nextKey)
            } else {
                LoadResult.Error(Exception("Network error"))
            }
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GithubRepositoryModel>): Int? {
        TODO("Not yet implemented")
    }
}