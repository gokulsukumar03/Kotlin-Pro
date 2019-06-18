package com.kotlin.demo.base.remote

import com.kotlin.demo.cricket.recyclerview.dto.PlayerDetailsModel
import io.reactivex.Single
import retrofit2.http.GET

interface AppWebServices {
    @GET(RemoteConstant.GET_PLAYER)
    fun getAllPlayerData(): Single<PlayerDetailsModel>
}