package com.kotlin.demo.dream11.dto

import com.google.gson.annotations.SerializedName
data class PlayerGroupsDTO(

	@field:SerializedName("group_id")
	val groupId: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("group")
	val group: String? = null,

	@field:SerializedName("max_selection_count_per_group")
	val maxSelectionCountPerGroup: Int? = null,

	@field:SerializedName("min_selection_count_per_group")
	val minSelectionCountPerGroup: Int? = null,

	@field:SerializedName("players")
	val players: List<PlayersDTO?>? = null,

	@field:SerializedName("group_icon")
	val groupIcon: String? = null,

	@field:SerializedName("group_name")
	val groupName: String? = null
)