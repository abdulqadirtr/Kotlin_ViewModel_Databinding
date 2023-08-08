package com.example.githubrepo_livedata.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo_livedata.databinding.RecyclerLayoutBinding
import com.example.githubrepo_livedata.data.model.MyData
import com.example.githubrepo_livedata.data.model.Repository
import com.example.githubrepo_livedata.databinding.ItemRepoLayoutBinding

class RepoAdapter: RecyclerView.Adapter<RepoAdapter.MyViewHolder>() {
    var items = ArrayList<Repository>()

    fun setData(data : List<Repository>){
        this.items.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  ItemRepoLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(val binding: ItemRepoLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: Repository){

            binding.gitHubData = data
            binding.executePendingBindings()
        }

    }

}
