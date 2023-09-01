package com.example.githubrepo_livedata.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepo_livedata.R
import com.example.githubrepo_livedata.data.model.GithubRepositoryModel
import com.example.githubrepo_livedata.databinding.RecyclerLayoutBinding

class DataAdapter: PagingDataAdapter<GithubRepositoryModel ,DataAdapter.MyViewHolder>(DiffCallback) {

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

            // Load the image using Glide
            val thumbImage = binding.thubmImage
            val imageUrl = data.owner.avatar_url // Assuming avatar_url is the image URL
            Glide.with(thumbImage)
                .load(imageUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbImage)


            binding.executePendingBindings()
        }

    }

}
