package com.kotlin.demo.fragment.fragmentdynamic.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel

class FragmentTabAdapter(manager : FragmentManager,  val moviesCategory : List<MoviesCategoryModel>) : FragmentStatePagerAdapter(manager){


    override fun getItem(position: Int): Fragment {
        return FragmentTabFragment.newInstance(moviesCategory[position])
    }

    override fun getCount(): Int {
        return moviesCategory.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return moviesCategory[position % moviesCategory.size].title
    }

}