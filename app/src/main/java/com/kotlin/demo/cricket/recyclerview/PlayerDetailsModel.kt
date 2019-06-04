package com.kotlin.demo.cricket.recyclerview

import com.google.gson.annotations.SerializedName
import com.kotlin.demo.cricket.recyclerview.dto.PlayerModel

class PlayerDetailsModel {
    @SerializedName("players")
        var player = ArrayList<PlayerModel>()
    }
