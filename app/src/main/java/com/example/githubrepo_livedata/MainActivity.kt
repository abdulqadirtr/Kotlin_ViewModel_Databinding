package com.example.githubrepo_livedata

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepo_livedata.databinding.ActivityMainBinding
import com.example.githubrepo_livedata.model.GithubResponseModel
import com.example.githubrepo_livedata.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = makeApi()
        setUpBind(viewModel)
    }
    fun setUpBind(viewModel: MainViewModel){
        val activityMainbing :ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainbing.setVariable(BR.viewModel, viewModel)
        activityMainbing.executePendingBindings()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            addItemDecoration(decoration)
        }
    }


    fun makeApi(): MainViewModel {
        val viewMode = ViewModelProvider(this).get(MainViewModel::class.java)

        viewMode.getGithubObserver().observe(this, Observer<GithubResponseModel> {

            if (it != null) {
                progressbar.visibility = View.INVISIBLE
                viewMode.setAdapterData(it.items)

            } else {
                Toast.makeText(this, "Error Fetching Data", Toast.LENGTH_LONG).show()
            }

        })

        viewMode.makeApiCall("newyork")
        return viewMode

    }
}