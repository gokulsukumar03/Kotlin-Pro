package com.kotlin.demo.fragment.fragmentdynamic.dto

import com.google.gson.annotations.SerializedName

class MoviesModel {

    @SerializedName("category")
    var moviesCategory: ArrayList<MoviesCategoryModel>?=null
}
