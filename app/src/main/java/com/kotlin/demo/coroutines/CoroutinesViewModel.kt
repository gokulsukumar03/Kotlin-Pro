package com.kotlin.demo.coroutines

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.AppWebServices
import com.kotlin.demo.base.remote.RetrofitConfig
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutinesViewModel : ViewModel(){

    private val moviesLiveData = MutableLiveData<MoviesModel>()

    private val parentJob = Job()

    private val coroutineContext : CoroutineContext get() = parentJob  + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val appWebServices : AppWebServices = RetrofitConfig.createKotlin()

    fun fetchMoviesData() : LiveData<MoviesModel>{
        fetchMovies()
        return moviesLiveData
    }

    private fun fetchMovies(){
        scope.launch {
            val movies = appWebServices.getMovies()
                moviesLiveData.postValue(movies.await())

        }
    }

    fun cancelAllRequest() = coroutineContext.cancel()

}
