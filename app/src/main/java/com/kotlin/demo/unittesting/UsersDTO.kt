package com.kotlin.demo.unittesting
import com.google.gson.annotations.SerializedName
data class UsersDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("company")
	val company: String? = null
)