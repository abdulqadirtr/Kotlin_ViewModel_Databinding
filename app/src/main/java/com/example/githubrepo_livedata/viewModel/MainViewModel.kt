package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.Result3
import com.example.githubrepo_livedata.data.adapter.RepoAdapter
import com.example.githubrepo_livedata.data.model.GithubResponseModel
import com.example.githubrepo_livedata.data.model.MyData
import com.example.githubrepo_livedata.data.model.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubResponseData = MutableLiveData<Result3<GithubResponseModel>>()
    val githubResponseData : LiveData<Result3<GithubResponseModel>> = _githubResponseData

    //this one is for the List to test the Error handling
    private val _githubRepo = MutableLiveData<Result3<List<Repository>>>()
    val githubRepo : LiveData<Result3<List<Repository>>> = _githubRepo


    //the first DataAdapter is without list
    var dataAdapter: DataAdapter = DataAdapter()

    //Directly getting list to sealed class
    var repoAdapter: RepoAdapter = RepoAdapter()

    init {
        makeApiCall()
        getAllRepo()
    }
    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun getMyRepoAdapter() : RepoAdapter{
        return repoAdapter
    }

    fun setAdapterData(data : ArrayList<MyData>){
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }

    fun setRepoData(data: List<Repository>){
        repoAdapter.setData(data)
        repoAdapter.notifyDataSetChanged()
    }


    fun makeApiCall(input: String?=null) = viewModelScope.launch {
        val response = repository.getAllRepository("kotlin")
        try{
            if(response.isSuccessful){
                _githubResponseData.value = Result3.Success(response.body()!!)
            }
        }
        catch (e: Exception){
            _githubResponseData.value = Result3.Error(e)
        }

    }

    fun getAllRepo() = viewModelScope.launch {
        val response = repository.getAll()
        try{
            if(response.isSuccessful){
                _githubRepo.value = Result3.Success(response.body()!!)
            }
        }
        catch (e: Exception){
            _githubRepo.value = Result3.Error(e)
        }

    }
}