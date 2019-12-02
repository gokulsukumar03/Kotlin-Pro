package com.kotlin.demo.dream11.dto

import com.google.gson.annotations.SerializedName
data class PlayersDTO(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("player_name")
	val playerName: String? = null,

	@field:SerializedName("player_id")
	val playerId: Int? = null,

	@field:SerializedName("is_playing")
	val isPlaying: Boolean? = null,

	@field:SerializedName("credits")
	val credits: Int? = null,

	@field:SerializedName("points")
	val points: Int? = null,

	@field:SerializedName("is_selected")
	val isSelected: Boolean? = null,

	@field:SerializedName("player_image")
	val playerImage: String? = null,

	@field:SerializedName("team")
	val team: TeamDTO? = null
)