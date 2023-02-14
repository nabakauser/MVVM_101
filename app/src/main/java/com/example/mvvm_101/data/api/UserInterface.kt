package com.example.mvvm_101.data.api

import com.example.mvvm_101.model.UserDataClass
//import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface UserInterface {
    @GET("posts")
    suspend fun getUserData() : Response<List<UserDataClass>>
}