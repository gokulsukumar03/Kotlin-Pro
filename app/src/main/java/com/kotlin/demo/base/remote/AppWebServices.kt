package com.kotlin.demo.base.remote

import com.kotlin.demo.cricket.recyclerview.PlayerDetailsModel
import io.reactivex.Single
import retrofit2.http.GET

interface AppWebServices {
    @GET("mrl67")
    fun getAllPlayerData(): Single<PlayerDetailsModel>
}