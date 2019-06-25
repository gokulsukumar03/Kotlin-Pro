package com.kotlin.demo.fragment.fragmentdynamic.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.AppWebServices
import com.kotlin.demo.base.remote.RetrofitConfig
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesCategoryModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FragmentTabViewModel : ViewModel() {

    private var moviesCategoryList : MutableLiveData<List<MoviesCategoryModel>> = MutableLiveData()

    fun getMovies() : LiveData<List<MoviesCategoryModel>>{
        fetchMovies()
        return moviesCategoryList
    }

    @SuppressLint("CheckResult")
    private fun fetchMovies(){
        val appWebServices : AppWebServices = RetrofitConfig.create()
        appWebServices.getMoviesData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                movies->
                moviesCategoryList.value=movies.moviesCategory!!
            }, {
                error->
                error.message
            })
    }
}