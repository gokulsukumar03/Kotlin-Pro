package com.kotlin.demo.fragment.fragmentdynamic.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.databinding.ActivityFragmentTabBinding
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel

class FragmentTabActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun setFullScreen(): Boolean {
        return true
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
            binding.viewPager.currentItem = 0
            binding.progressHorizontal.visibility= View.GONE


        })



    }


}
