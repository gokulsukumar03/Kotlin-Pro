package com.kotlin.demo.base.remote

import com.kotlin.demo.cricket.recyclerview.dto.PlayerDetailsModel
import com.kotlin.demo.dream11.dto.DreamResponseDTO
import com.kotlin.demo.fragment.fragmentdynamic.dto.MoviesModel
import com.kotlin.demo.unittesting.JunitDto
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AppWebServices {
    @GET(RemoteConstant.GET_PLAYER)
    fun getAllPlayerData(): Single<PlayerDetailsModel>

    @GET(RemoteConstant.GET_MOVIES)
    fun getMoviesData() : Single<MoviesModel>

    @GET(RemoteConstant.GET_MOVIES)
    fun getMovies() : Deferred<MoviesModel>

    @GET(RemoteConstant.GET_DREAM_TEAM)
    fun getDreamTeam() : Single<DreamResponseDTO>

    @GET(RemoteConstant.GET_USERS)
    fun getUsers() : Observable<JunitDto>
}