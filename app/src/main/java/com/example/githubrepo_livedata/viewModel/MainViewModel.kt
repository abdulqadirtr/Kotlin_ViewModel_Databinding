package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.Result
import com.example.githubrepo_livedata.data.Result2
import com.example.githubrepo_livedata.data.Result3
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import com.example.githubrepo_livedata.data.model.MyData
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<Result3<GithubResponseModel>>()
    val githubResponseData : LiveData<Result3<GithubResponseModel>> = _githubResponseData


    var dataAdapter: DataAdapter = DataAdapter()

    init {
        makeApiCall()
    }
    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data : ArrayList<MyData>){
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }


    fun makeApiCall(input: String?=null) {
        repository.getAllRepository("kotlin").enqueue(object : retrofit2.Callback<GithubResponseModel> {
            override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                //_githubResponseData.value = Result2.Error(t.message)
            }

            override fun onResponse(
                call: Call<GithubResponseModel>,
                response: Response<GithubResponseModel>
            ) {
               /* if (!response.isSuccessful()) _githubResponseData.value =
                    null else _githubResponseData.value = response.body()*/
                if (response.isSuccessful) {
                    /*_githubResponseData.postValue(Result2.Success(response.body()!!))*/
                    _githubResponseData.postValue(Result3.Success(response.body()!!))
                }

            }


        })

    }
}