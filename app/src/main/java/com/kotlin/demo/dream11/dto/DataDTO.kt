package com.kotlin.demo.dream11.dto

import com.google.gson.annotations.SerializedName
data class DataDTO(

	@field:SerializedName("max_player_limit")
	val maxPlayerLimit: Int? = null,

	@field:SerializedName("credits")
	val credits: Int? = null,

	@field:SerializedName("is_announced")
	val isAnnounced: Boolean? = null,

	@field:SerializedName("teams")
	val teams: List<TeamsDTO?>? = null,

	@field:SerializedName("player_groups")
	val playerGroups: List<PlayerGroupsDTO?>? = null
)