package com.example.githubrepo_livedata

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


object BindingAdapterUtils {
   /* @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(thumbimg: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(thumbimg)
    }*/

    @JvmStatic
    @BindingAdapter("loadImage")
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