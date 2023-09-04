package com.example.githubrepo_livedata.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepo_livedata.BR
import com.example.githubrepo_livedata.data.adapter.DataAdapter
import com.example.githubrepo_livedata.data.adapter.LoadMoreAdapter
import com.example.githubrepo_livedata.databinding.FragmentMainBinding
import com.example.githubrepo_livedata.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {

    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.setVariable(BR.viewModel, mainViewModel)
        binding.executePendingBindings()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val decoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
            adapter = mainViewModel.dataAdapter.withLoadStateFooter(LoadMoreAdapter())
        }


        initObserver()

    }

    private fun initObserver() {

        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.repositories.collect {
                    mainViewModel.setAdapterData(it)
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            mainViewModel.dataAdapter.loadStateFlow.collect{
                val state = it.refresh
                binding.progressbar.isVisible = state is LoadState.Loading
            }
        }


    }

}