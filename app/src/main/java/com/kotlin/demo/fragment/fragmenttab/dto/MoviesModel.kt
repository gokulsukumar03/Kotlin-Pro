package com.kotlin.demo.fragment.fragmenttab.dto

import com.google.gson.annotations.SerializedName

class MoviesModel {

    @SerializedName("category")
    var moviesCategory: ArrayList<MoviesCategoryModel>?=null
}
