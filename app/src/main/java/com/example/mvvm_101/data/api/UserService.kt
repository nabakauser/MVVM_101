package com.example.mvvm_101.data.api

import com.example.mvvm_101.data.api.UserInterface
import com.example.mvvm_101.model.UserDataClass
//import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//
//class UserService {
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(getRetrofitClient())
//            .addConverterFactory(GsonConverterFactory.create())
////                A call adapter which uses RxJava 2 for creating observables.
////                Adding this class to Retrofit allows you
////                to return an Observable, Flowable, Single,
////                Completable or Maybe from service methods.
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//            .create(UserInterface::class.java)
//
//        fun getUsers(): Call<List<UserDataClass>> {
//            return retrofit.getUserData()
//        }
//
//    private fun getRetrofitClient() : OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor())
//            .build()
//    }
//
//    private fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply{
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//}

class UserService {
    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//        userInstance = retrofit.create(UserInterface::class.java)

//        fun getUsers(): Call<List<UserDataClass>> {
//            return retrofit.getUserData()
//        }
    }

    private fun getRetrofitClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .build()
    }

    private fun httpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}