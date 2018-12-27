package com.paging.packt.paging

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GitRepoAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemViewModel = ViewModelProviders.of(this).get(GitRepoViewModel::class.java)

        itemViewModel.gitRepoPagedList.observe(this, Observer {
            adapter.submitList(it)
        })

        recyclerView.adapter = adapter
    }
}
