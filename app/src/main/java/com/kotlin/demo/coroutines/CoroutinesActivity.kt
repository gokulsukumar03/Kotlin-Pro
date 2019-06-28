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
import android.databinding.DataBindingUtil
import android.widget.Toast
import com.kotlin.demo.base.remote.FailedEvent
import com.kotlin.demo.base.remote.LoadingEvent
import com.kotlin.demo.base.remote.SuccessEvent
import com.kotlin.demo.databinding.ActivityCoroutinesBinding

class CoroutinesActivity : BaseActivity() {
    override fun getScreenName(): String {
        return localClassName
    }

    override fun setFullScreen(): Boolean {
        return false
    }

    private lateinit var viewModel: CoroutinesViewModel
    private lateinit var binding :ActivityCoroutinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines)
        viewModel = ViewModelProviders.of(this).get(CoroutinesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        viewModel.mEvents.observe(this, Observer { event ->
            event?.let {
                when (event) {
                    LoadingEvent -> binding.textTv.text="Loading..."
                    SuccessEvent -> binding.textTv.text="Success..."
                    is FailedEvent -> binding.textTv.text=event.error.message!!
                    else -> binding.textTv.text="else"
                }
            }
        })

        viewModel.fetchMoviesData().observe(this, Observer {
            movies->
            if (movies != null) {
                Toast.makeText(this@CoroutinesActivity,  movies.moviesCategory?.get(0)!!.title , Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroy() {
        viewModel.cancelAllRequest()
        super.onDestroy()
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
