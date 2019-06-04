package com.kotlin.demo.cricket.recyclerview.dto

import com.google.gson.annotations.SerializedName

// https://android.jlelse.eu/kotlin-for-android-developers-data-class-c2ad51a32844
 class PlayerModel
 {
    @SerializedName("playerImage")
    var playerImage: String?=null

    @SerializedName("playerName")
    var playerName: String?=null

    @SerializedName("playerGender")
    var playerGender: String?=null

    @SerializedName("playerCountry")
    var playerCountry: String?=null

    @SerializedName("playerMode")
    var playerMode: String?=null

    @SerializedName("playerPoint")
    var playerPoint: Int?=null

    @SerializedName("playerCredit")
    var playerCredit: Int?=null

    @SerializedName("isPlayerSelected")
    var isPlayerSelected: Boolean?=null

}

