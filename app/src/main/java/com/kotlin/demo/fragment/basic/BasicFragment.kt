package com.kotlin.demo.fragment.basic


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.demo.R
import com.kotlin.demo.base.fragment.BaseFragment

class BasicFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contest, container, false)
    }


}
