package com.kotlin.demo.cricket.recyclerview.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demo.base.remote.AppWebServices
import com.kotlin.demo.base.remote.RetrofitConfig
import com.kotlin.demo.cricket.recyclerview.dto.PlayerModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PlayerRecyclerViewModel : ViewModel() {

    private val playerModelListMutableLiveData: MutableLiveData<List<PlayerModel>> = MutableLiveData()


    fun getAllPlayer(): LiveData<List<PlayerModel>> {
        getAllUserFromApi()
        return playerModelListMutableLiveData
    }

    @SuppressLint("CheckResult")
    private fun getAllUserFromApi() {
        val appWebServices: AppWebServices = RetrofitConfig.create()
        appWebServices.getAllPlayerData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                    playerDetailsModel ->
                playerModelListMutableLiveData.value = playerDetailsModel.player
            }, { error ->
                error.message
            })

    }
}



























