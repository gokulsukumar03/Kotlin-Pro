package com.kotlin.demo.fragment.basic

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.databinding.ActivityContestBinding

class BasicFragmentActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    lateinit var binding: ActivityContestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contest)
    }


    override fun onResume() {
        super.onResume()
        setUpFragment()
    }

    fun setUpFragment() {
        val basicFragment = BasicFragment()
        val manager: FragmentManager
        val transaction: FragmentTransaction

        manager = supportFragmentManager
        transaction = manager.beginTransaction()
        transaction.add(R.id.frame_layout, basicFragment)
        transaction.commit()

    }
}
