package com.kotlin.demo.coroutines

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.kotlin.demo.R
import com.kotlin.demo.base.activity.BaseActivity
import com.kotlin.demo.home.AppConstant
import kotlinx.coroutines.*
import java.util.*
import android.arch.lifecycle.Observer
import android.widget.Toast

class CoroutinesActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun setFullScreen(): Boolean {
        return false
    }

    private lateinit var viewModel: CoroutinesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        viewModel = ViewModelProviders.of(this).get(CoroutinesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchMoviesData().observe(this, Observer {
            movies->
            if (movies != null) {
                Toast.makeText(this@CoroutinesActivity,  movies.moviesCategory?.get(0)!!.title , Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun  test(){
        GlobalScope.launch {
            withContext(Dispatchers.Default) { defaultCoroutine() }
        }


        GlobalScope.launch(Dispatchers.Default) {
            val deferredOne = async { defaultAsyncCoRoutine() }
            deferredOne.await()

        }
    }

    private fun defaultCoroutine() {
        Log.d(AppConstant.LogCatName, "start time   " + Date().toString())
        for (i in 1..1000) {
            Log.d(AppConstant.LogCatName, String.format("%s", i))
        }
        Log.d(AppConstant.LogCatName, "end time   " + Date().toString())
    }

    private fun defaultAsyncCoRoutine(): String {
        Log.d(AppConstant.LogCatName, "start time   " + Date().toString())
        for (i in 1..100) {
            Log.d(AppConstant.LogCatName, String.format("%s", i))
        }
        Log.d(AppConstant.LogCatName, "end time   " + Date().toString())

        return "Finished..."
    }


}
