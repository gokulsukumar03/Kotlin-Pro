package com.kotlin.demo.base.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig<T> {

    companion object {
        fun create(): AppWebServices {


            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RemoteConstant.BASE_URL)
                .build()

            return retrofit.create(AppWebServices::class.java)
        }
    }
}