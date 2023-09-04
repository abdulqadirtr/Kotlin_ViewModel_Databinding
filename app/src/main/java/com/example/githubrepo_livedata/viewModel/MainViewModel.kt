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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val ITEMS_PER_PAGE = 5
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GithubRepository) : ViewModel() {



    //the first DataAdapter is without list
    var dataAdapter: DataAdapter = DataAdapter()

    val repositories: Flow<PagingData<GithubRepositoryModel>> = Pager(PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false)) {
        GithubPagingSource(repository)
    }.flow
        .cachedIn(viewModelScope)



   fun setAdapterData(data: PagingData<GithubRepositoryModel>) {
        viewModelScope.launch {
            dataAdapter.submitData(data)
        }
    }
}