package com.example.restapi.pojo

import com.google.gson.annotations.SerializedName

data class Post(@SerializedName("id") val id: Int,
		val name: String, 
		val email: String,
		val phone: String)
