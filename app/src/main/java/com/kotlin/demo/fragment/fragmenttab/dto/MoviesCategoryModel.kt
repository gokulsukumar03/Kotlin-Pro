package com.kotlin.demo.fragment.fragmenttab.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MoviesCategoryModel : Serializable {

    @SerializedName("id")
    var id: Int?=null

    @SerializedName("title")
    var title: String?=null

    @SerializedName("movies")
    var movies: ArrayList<MoviesDetailModel>?=null

}