package com.kotlin.demo.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getScreenName() : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext,getScreenName(),Toast.LENGTH_SHORT).show()
    }
}