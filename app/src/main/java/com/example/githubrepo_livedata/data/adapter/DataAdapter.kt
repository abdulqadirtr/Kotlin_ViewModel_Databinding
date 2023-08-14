package com.example.githubrepo_livedata.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import com.example.githubrepo_livedata.databinding.RecyclerLayoutBinding

class DataAdapter: PagingDataAdapter<GithubRepositoryModel ,DataAdapter.MyViewHolder>(DiffCallback) {
    var items = ArrayList<GithubRepositoryModel>()

    fun setData(data: List<GithubRepositoryModel>) {
        this.items.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  RecyclerLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }
    object DiffCallback : DiffUtil.ItemCallback<GithubRepositoryModel>() {
        override fun areItemsTheSame(oldItem: GithubRepositoryModel, newItem: GithubRepositoryModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GithubRepositoryModel, newItem: GithubRepositoryModel): Boolean {
            return oldItem == newItem
        }
    }

    class MyViewHolder(val binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: GithubRepositoryModel){

            binding.gitHubData = data
            binding.executePendingBindings()
        }

    }

}
