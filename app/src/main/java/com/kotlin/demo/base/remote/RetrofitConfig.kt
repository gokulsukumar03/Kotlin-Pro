package com.kotlin.demo.base.remote
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig<T> {

    companion object {
        fun create(): AppWebServices {
            val retrofit = Retrofit.Builder()
                .baseUrl(RemoteConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(AppWebServices::class.java)
        }

        fun createKotlin(): AppWebServices {
            val retrofit = Retrofit.Builder()
                .baseUrl(RemoteConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
            return retrofit.create(AppWebServices::class.java)
        }
    }
}