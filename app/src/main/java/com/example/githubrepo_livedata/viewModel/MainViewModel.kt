package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import com.example.githubrepo_livedata.ui.Result3
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubRepo = MutableLiveData<Result3<List<GithubRepositoryModel>>>()
    val githubRepo: LiveData<Result3<List<GithubRepositoryModel>>> = _githubRepo


    //the first DataAdapter is without list
    var dataAdapter: DataAdapter = DataAdapter()


    init {
        getAllRepo()
    }

    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data: List<GithubRepositoryModel>) {
        dataAdapter.setData(data)
        dataAdapter.notifyDataSetChanged()
    }

    fun getAllRepo() = viewModelScope.launch {
        val response = repository.getAllRepository(5,5)
        try {
            if (response.isSuccessful) {
                _githubRepo.value = Result3.Success(response.body()!!)
            }
        } catch (e: Exception) {
            _githubRepo.value = Result3.Error(e)
        }
    }
}