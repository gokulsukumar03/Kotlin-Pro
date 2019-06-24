package com.kotlin.demo.fragment.fragmenttab.dto

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MoviesCategoryModel() : Parcelable {

    @SerializedName("id")
    var id: Int?=null

    @SerializedName("title")
    var title: String?=null

    @SerializedName("movies")
    var movies: ArrayList<MoviesDetailModel>?=null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesCategoryModel> {
        override fun createFromParcel(parcel: Parcel): MoviesCategoryModel {
            return MoviesCategoryModel(parcel)
        }

        override fun newArray(size: Int): Array<MoviesCategoryModel?> {
            return arrayOfNulls(size)
        }
    }

}