package com.example.githubrepo_livedata.data.model

data class GithubResponseModel(val items: ArrayList<MyData>)

data class MyData(val name: String, val description: String, val created_at: String, val owner: Owner)

data class Owner(val avatar_url: String)