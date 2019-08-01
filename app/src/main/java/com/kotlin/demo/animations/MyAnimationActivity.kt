package com.kotlin.demo.animations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_my_animation.*

class MyAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_animation)
    }

    override fun onResume() {
        super.onResume()
        animateBottomToScreen()
    }

    fun animateBottomToScreen(){

        var slideUpAnimation  = AnimationUtils.loadAnimation(this@MyAnimationActivity, R.anim.slideup)
        bottomLayout.startAnimation(slideUpAnimation)
    }
}
