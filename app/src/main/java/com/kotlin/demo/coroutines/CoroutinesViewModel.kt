package com.kotlin.demo.coroutines

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.*
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesModel
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class CoroutinesViewModel : ViewModel(){

    private val moviesLiveData = MutableLiveData<MoviesModel>()

    private val parentJob = Job()

    private val coroutineContext : CoroutineContext get() = parentJob  + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val appWebServices : AppWebServices = RetrofitConfig.createKotlin()

    val mEvents = MutableLiveData<Event>()

    fun fetchMoviesData() : LiveData<MoviesModel>{
        fetchMovies()
        return moviesLiveData
    }

    private fun fetchMovies(){
        mEvents.value=LoadingEvent
        scope.launch {
            try{
                val movies = appWebServices.getMovies().await()
                moviesLiveData.postValue(movies)
                mEvents.postValue(SuccessEvent)
            }
            catch(throwable : Throwable){
                mEvents.postValue(FailedEvent(throwable))
            }

        }
    }

    fun cancelAllRequest() = coroutineContext.cancel()

}
