package com.example.githubrepo_livedata.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepo_livedata.DataAdapter
import com.example.githubrepo_livedata.NetworkApi.ApiEndPoint
import com.example.githubrepo_livedata.NetworkApi.RetrofitClient
import com.example.githubrepo_livedata.model.GithubResponseModel
import com.example.githubrepo_livedata.model.MyData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel(name: String) : ViewModel() {

    var githubResponseData: MutableLiveData<GithubResponseModel>
    lateinit var dataAdapter: DataAdapter

    var myName = name

    init {
        githubResponseData = MutableLiveData()
        dataAdapter = DataAdapter()

        Log.d("MainViewModel", "My name is $name")
    }

    fun getGithubObserver(): MutableLiveData<GithubResponseModel> {

        return githubResponseData
    }

    fun getAdapter(): DataAdapter{
        return dataAdapter
    }

    fun setAdapterData(data : ArrayList<MyData>){
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }
    fun makeApiCall(input: String) {

        val myData = RetrofitClient.getRetrofitInstance().create(ApiEndPoint::class.java)
        val call = myData.getAllRepo("network")
        call.enqueue(object : retrofit2.Callback<GithubResponseModel> {
            override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                githubResponseData.value = null
            }

            override fun onResponse(
                call: Call<GithubResponseModel>,
                response: Response<GithubResponseModel>
            ) {
                if (!response.isSuccessful()) githubResponseData.value =
                    null else githubResponseData.value = response.body()
            }


        })

    }

}