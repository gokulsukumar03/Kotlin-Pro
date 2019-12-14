package com.kotlin.demo.unittesting
import com.google.gson.annotations.SerializedName
data class JunitDto(

	@field:SerializedName("response_code")
	val responseCode: String? = null,

	@field:SerializedName("users")
	val users: List<UsersDTO?>? = null
)