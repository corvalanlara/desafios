package com.example.restapi.remote

import com.example.restapi.pojo.Post
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface Api {
    @GET("/photos")
    fun getAllPosts(): Call<ArrayList<Post>>

    //@DELETE("/users/{userId}")
    //fun deletePost(@Path("userId") userId: Int?): Call<Void>


}
