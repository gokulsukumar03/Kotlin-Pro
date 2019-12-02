package com.kotlin.demo.dream11.dto

import com.google.gson.annotations.SerializedName
data class TeamsDTO(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("max_players_count")
	val maxPlayersCount: Int? = null,

	@field:SerializedName("min)players_count")
	val minPlayersCount: Int? = null,

	@field:SerializedName("team_image")
	val teamImage: String? = null
)