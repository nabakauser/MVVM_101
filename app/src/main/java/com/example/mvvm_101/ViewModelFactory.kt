package com.example.mvvm_101

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_101.viewmodel.UserViewModel

class ViewModelFactory(private val mainRepository: MainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(mainRepository) as T    }
}