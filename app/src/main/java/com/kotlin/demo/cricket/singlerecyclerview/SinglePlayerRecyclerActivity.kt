package com.kotlin.demo.cricket.singlerecyclerview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.kotlin.demo.R
import com.kotlin.demo.databinding.ActivitySinglePlayerRecyclerBinding

class SinglePlayerRecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySinglePlayerRecyclerBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var singlePlayerRecyclerActivity: SinglePlayerRecyclerActivity
    private lateinit var singlePlayerRecyclerViewModel: SinglePlayerRecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_player_recycler)
        renderView()
    }

    fun renderView() {
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager
        getPlayerData()
    }

    fun getPlayerData(){

    }
}
