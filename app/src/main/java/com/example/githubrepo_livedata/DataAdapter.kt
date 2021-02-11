package com.example.githubrepo_livedata

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubrepo_livedata.databinding.RecyclerLayoutBinding
import com.example.githubrepo_livedata.model.GithubResponseModel
import com.example.githubrepo_livedata.model.MyData

class DataAdapter: RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    var items = ArrayList<MyData>()

    fun setData(data : ArrayList<MyData>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val binding =  com.example.githubrepo_livedata.databinding.RecyclerLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(val binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: MyData){

            binding.gitHubData = data
            binding.executePendingBindings()
        }

    }
    companion object {

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(thumbimg : ImageView, url : String){
            Glide.with(thumbimg)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbimg)

        }

    }

}
