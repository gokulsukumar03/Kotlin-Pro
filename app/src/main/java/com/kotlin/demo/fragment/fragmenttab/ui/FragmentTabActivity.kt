package com.kotlin.demo.fragment.fragmenttab.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.databinding.ActivityFragmentTabBinding
import com.kotlin.demo.fragment.fragmenttab.dto.MoviesCategoryModel

class FragmentTabActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun setFullScreen(): Boolean {
        return false
    }

    private lateinit var binding : ActivityFragmentTabBinding
    private lateinit var viewModel : FragmentTabViewModel
    private lateinit var adapter : FragmentTabAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_tab)
        viewModel = ViewModelProviders.of(this).get(FragmentTabViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        setupMovieData()
    }

    fun setupMovieData(){
        viewModel.getMovies().observe(this, Observer<List<MoviesCategoryModel>> {
            movies->
            adapter = FragmentTabAdapter(supportFragmentManager, movies!!)
            binding.viewPager.adapter = adapter
            binding.tabLayout.setupWithViewPager(binding.viewPager)
            binding.viewPager.currentItem = adapter.count/2
        })



    }


}
