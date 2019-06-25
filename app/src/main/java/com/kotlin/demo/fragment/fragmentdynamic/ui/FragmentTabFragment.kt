package com.kotlin.demo.fragment.fragmentdynamic.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.demo.R
import com.kotlin.demo.base.BaseConstant
import com.kotlin.demo.databinding.FragmentFragmentTabBinding
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel

class FragmentTabFragment : Fragment() {

    private lateinit var binding: FragmentFragmentTabBinding
    private lateinit var bundle: Bundle
    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var movieCategoryData : MoviesCategoryModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance(moviesCategoryModel: MoviesCategoryModel): FragmentTabFragment {
            val args = Bundle()
            args.putParcelable(BaseConstant.MOVIES_TAG, moviesCategoryModel)
            val fragment = FragmentTabFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_fragment_tab, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null) {
            bundle = arguments!!
            if (bundle.containsKey(BaseConstant.MOVIES_TAG)) {

                movieCategoryData = bundle.getParcelable(BaseConstant.MOVIES_TAG)!!
                if(movieCategoryData.movies!=null && movieCategoryData.movies!!.size>0) {
                    staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    binding.recyclerView.layoutManager = staggeredGridLayoutManager
                    moviesAdapter = MoviesAdapter(this@FragmentTabFragment.context!!, movieCategoryData.movies!!)
                    binding.recyclerView.adapter=moviesAdapter
                }
            }

        }
    }

}
