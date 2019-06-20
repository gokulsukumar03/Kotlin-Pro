package com.kotlin.demo.cricket.recyclerview.dto

import com.google.gson.annotations.SerializedName

class PlayerDetailsModel {
    @SerializedName("players")
        var player = ArrayList<PlayerModel>()
    }
