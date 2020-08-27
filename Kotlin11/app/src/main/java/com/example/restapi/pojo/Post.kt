package com.example.restapi.pojo

import com.google.gson.annotations.SerializedName

data class Post(val id: Int,
		val title: String, 
		val url: String,
		val thumbnailUrl: String)
