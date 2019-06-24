package com.kotlin.demo.base.remote

import com.kotlin.demo.cricket.recyclerview.dto.PlayerDetailsModel
import com.kotlin.demo.fragment.fragmenttab.dto.MoviesModel
import io.reactivex.Single
import retrofit2.http.GET

interface AppWebServices {
    @GET(RemoteConstant.GET_PLAYER)
    fun getAllPlayerData(): Single<PlayerDetailsModel>

    @GET(RemoteConstant.GET_MOVIES)
    fun getMoviesData() : Single<MoviesModel>
}