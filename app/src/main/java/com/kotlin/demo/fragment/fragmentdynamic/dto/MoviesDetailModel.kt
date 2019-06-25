package com.kotlin.demo.fragment.fragmentdynamic.dto

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MoviesDetailModel() : Parcelable {

    @SerializedName("id")
    var id: Int?=null

    @SerializedName("rating")
    var rating: Int?=null

    @SerializedName("title")
    var title: String?=null

    @SerializedName("posterUri")
    var posterUri: String?=null

    @SerializedName("overview")
    var overview: String?=null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        rating = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        posterUri = parcel.readString()
        overview = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(rating)
        parcel.writeString(title)
        parcel.writeString(posterUri)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesDetailModel> {
        override fun createFromParcel(parcel: Parcel): MoviesDetailModel {
            return MoviesDetailModel(parcel)
        }

        override fun newArray(size: Int): Array<MoviesDetailModel?> {
            return arrayOfNulls(size)
        }
    }


}