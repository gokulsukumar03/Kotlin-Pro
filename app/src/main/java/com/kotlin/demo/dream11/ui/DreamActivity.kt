package com.kotlin.demo.dream11.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.demo.R

class DreamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream)
        supportFragmentManager.beginTransaction().add(R.id.dream_frame_layout, DreamFragment()).commit()
    }

}
