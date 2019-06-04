package com.kotlin.demo.cricket.recyclerview.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.demo.R
import com.kotlin.demo.databinding.ActivityRecyclerBinding
import com.kotlin.demo.cricket.recyclerview.dto.PlayerModel

class PlayerRecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var playerRecyclerAdapter: PlayerRecyclerAdapter
    private lateinit var playerRecyclerViewModel: PlayerRecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler)
        playerRecyclerViewModel = ViewModelProviders.of(this).get(PlayerRecyclerViewModel::class.java)
        renderView()
    }

    fun renderView() {
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        getPlayerData()
    }

    fun getPlayerData(){
        playerRecyclerViewModel.getAllPlayer().observe(this, Observer<List<PlayerModel>> { playerModelList->
            playerRecyclerAdapter = PlayerRecyclerAdapter(this, playerModelList)
            binding.recyclerView.adapter = playerRecyclerAdapter
        })
    }
}



