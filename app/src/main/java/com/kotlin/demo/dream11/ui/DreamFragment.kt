package com.kotlin.demo.dream11.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.demo.R
import com.kotlin.demo.base.fragment.BaseFragment
import com.kotlin.demo.databinding.FragmentDreamBinding

class DreamFragment : BaseFragment() {

    var binding: FragmentDreamBinding? = null
    var viewModel: DreamViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dream, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DreamViewModel::class.java)

        viewModel?.let {
            viewModel!!.fetchDreamTeam()
            viewModel!!.dreamResponseDTO.observe(this, Observer { })
        } ?: run {

        }

    }

}