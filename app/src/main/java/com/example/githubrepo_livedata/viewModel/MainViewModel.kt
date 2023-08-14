package com.example.githubrepo_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.githubrepo_livedata.data.GithubPagingSource
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.GithubRepository
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import com.example.githubrepo_livedata.ui.Result3
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GithubRepository) : ViewModel() {

    private val _githubRepo = MutableLiveData<Result3<List<GithubRepositoryModel>>>()
    val githubRepo: LiveData<Result3<List<GithubRepositoryModel>>> = _githubRepo


    //the first DataAdapter is without list
    var dataAdapter: DataAdapter = DataAdapter()

    val repositories = Pager(PagingConfig(pageSize = 1)) {
        GithubPagingSource(repository)
    }.flow.cachedIn(viewModelScope)


    init {
    }

    fun getAdapter(): DataAdapter {
        return dataAdapter
    }

    fun setAdapterData(data: PagingData<GithubRepositoryModel>) {
        viewModelScope.launch {
            dataAdapter.submitData(data)
        }
    }
}