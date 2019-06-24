package com.kotlin.demo.fragment.fragmenttab.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.demo.R
import com.kotlin.demo.fragment.fragmenttab.dto.MoviesCategoryModel

class FragmentTabFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    companion object {
        fun newInstance(moviesCategoryModel: MoviesCategoryModel): FragmentTabFragment {
            val args = Bundle()
            args.putSerializable("", moviesCategoryModel)
            val fragment = FragmentTabFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fragment_tab, container, false)
    }


}
