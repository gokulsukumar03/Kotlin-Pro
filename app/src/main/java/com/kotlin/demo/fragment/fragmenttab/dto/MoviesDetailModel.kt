package com.kotlin.demo.fragment.fragmenttab.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MoviesDetailModel : Serializable {

    @SerializedName("rating")
    var id: Int?=null

    @SerializedName("title")
    var title: String?=null

    @SerializedName("posterUri")
    var posterUri: String?=null

    @SerializedName("overview")
    var overview: String?=null
}