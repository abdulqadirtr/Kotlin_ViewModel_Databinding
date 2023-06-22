package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import com.example.githubrepo_livedata.data.model.MyData
import retrofit2.Call
import retrofit2.Response
import com.example.githubrepo_livedata.ui.Result

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<Result<GithubResponseModel>>()
    val githubResponseData: LiveData<Result<GithubResponseModel>> = _githubResponseData

    var dataAdapter: DataAdapter = DataAdapter()

    init {
        makeApiCall()
    }

    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data: ArrayList<MyData>) {
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }


    private fun makeApiCall(input: String? = null) {
        repository.getAllRepository("kotlin")
            .enqueue(object : retrofit2.Callback<GithubResponseModel> {
                override fun onFailure(call: Call<GithubResponseModel>, t: Throwable) {
                    _githubResponseData.value = null
                }

                override fun onResponse(
                    call: Call<GithubResponseModel>,
                    response: Response<GithubResponseModel>
                ) {
                    if (response.isSuccessful) {
                        _githubResponseData.value = Result.Success(response.body()!!)
                    } else {
                        _githubResponseData.value = Result.Error(
                            Exception("API call failed with code: ${response.code()}"),
                            ("Error code : ${response.message()}")
                        )
                    }
                }


            })

    }
}