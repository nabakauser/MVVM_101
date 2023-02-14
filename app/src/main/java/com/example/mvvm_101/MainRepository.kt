package com.example.mvvm_101

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_101.data.api.UserInterface
import com.example.mvvm_101.model.UserDataClass

class MainRepository (private val retrofitService: UserInterface) {

    private val userLiveData = MutableLiveData<List<UserDataClass>>()

        val users: LiveData<List<UserDataClass>>
        get() = userLiveData


    suspend fun getAllUserData() {
        val result = retrofitService.getUserData()
        if(result.body() != null) {
            userLiveData.postValue(result.body())
        }
    }

}