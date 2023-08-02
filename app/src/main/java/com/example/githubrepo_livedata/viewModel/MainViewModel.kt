package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import com.example.githubrepo_livedata.data.model.MyData
import com.example.githubrepo_livedata.ui.Result
import kotlinx.coroutines.launch

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


    private fun makeApiCall(input: String? = null) = viewModelScope.launch {
        try {
            val response = repository.getAllRepository("kotlin")
            if (response.isSuccessful) {
                _githubResponseData.value = Result.Success(response.body()!!)
            }
            else{
                _githubResponseData.value = Result.Error(response.message())
            }
        }
        catch (e : Exception){
            _githubResponseData.value = Result.ErrorException(e)
        }

    }
}