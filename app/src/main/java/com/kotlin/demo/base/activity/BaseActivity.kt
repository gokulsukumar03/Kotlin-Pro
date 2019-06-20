package com.kotlin.demo.base.activity

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.kotlin.demo.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getScreenName() : String

    abstract fun setFullScreen() : Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(setFullScreen()){ window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)}
        setContentView(R.layout.activity_main)
        setStatusBarColor()
        Toast.makeText(applicationContext,getScreenName(),Toast.LENGTH_SHORT).show()
    }

    private fun setStatusBarColor(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
           var window : Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor=this.resources.getColor(R.color.blue_2D5FA6)
        }
    }
}