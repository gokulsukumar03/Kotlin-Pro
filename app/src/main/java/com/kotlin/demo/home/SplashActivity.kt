package com.kotlin.demo.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity

class SplashActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun setFullScreen(): Boolean {
        return true
    }

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        loadHome()
    }

    override fun onRestart() {
        super.onRestart()
        loadHome()
    }

    override fun onStop() {
        mHandler.removeCallbacks(mRunnable)
        super.onStop()
    }

    fun loadHome(){
        mHandler = Handler()
        mRunnable = Runnable {
            startActivity(Intent(this, HomeActivity::class.java))
            finishAffinity()
        }
        mHandler.postDelayed(mRunnable, 2000)
    }
}
