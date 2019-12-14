package com.kotlin.demo.unittesting

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.AppWebServices
import com.kotlin.demo.base.remote.RetrofitConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MyJUnitViewModel : ViewModel() {

    var jUnitDto = MutableLiveData<JunitDto>()
    var compositeDisposable = CompositeDisposable()

    public fun fetchUsers() {

        val appWebServices: AppWebServices = RetrofitConfig.create()
        appWebServices.getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ onSuccess ->
                jUnitDto.value = onSuccess
            }, { onError ->
                onError.message
            }).addTo(compositeDisposable)
    }

}
