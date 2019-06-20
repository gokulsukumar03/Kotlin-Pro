package com.kotlin.demo.fragment.fragmenttab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity

class FragmentTabActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_tab)
    }
}
