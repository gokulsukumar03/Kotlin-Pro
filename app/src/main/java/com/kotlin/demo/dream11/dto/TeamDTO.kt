package com.kotlin.demo.dream11.dto


import com.google.gson.annotations.SerializedName
data class TeamDTO(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("name")
	val name: String? = null
)