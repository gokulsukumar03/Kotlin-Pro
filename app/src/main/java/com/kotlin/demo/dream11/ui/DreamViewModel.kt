package com.kotlin.demo.dream11.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.AppWebServices
import com.kotlin.demo.base.remote.RetrofitConfig
import com.kotlin.demo.dream11.dto.DreamResponseDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.subscribeBy

class DreamViewModel : ViewModel() {

    var dreamResponseDTO = MutableLiveData<DreamResponseDTO>()
    private val compositeDisposable = CompositeDisposable()

    fun fetchDreamTeam() {
        val appWebServices: AppWebServices = RetrofitConfig.create()
        appWebServices.getDreamTeam()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = { response ->
                response?.data?.let {
                    dreamResponseDTO.value = response
                }
            }, onError = {


            }).addTo(compositeDisposable)

    }
}