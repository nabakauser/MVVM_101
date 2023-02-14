package com.example.mvvm_101.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_101.MainRepository
import com.example.mvvm_101.UserAdapter
import com.example.mvvm_101.data.api.UserService
import com.example.mvvm_101.model.UserDataClass
import kotlinx.coroutines.*
import retrofit2.Call
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.observers.DisposableSingleObserver
//import io.reactivex.schedulers.Schedulers
//import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel (private val mainRepository: MainRepository) : ViewModel() {

init {
    viewModelScope.launch(Dispatchers.IO) {
        mainRepository.getAllUserData()
    }
}
    val users: LiveData<List<UserDataClass>>
    get() = mainRepository.users
}


//class UserViewModel: ViewModel() {
//    val users = MutableLiveData<List<UserDataClass>>()
//    private val userService: UserService = UserService()
//    private val userAdapter: UserAdapter by lazy {UserAdapter(
//        userList = arrayListOf(),
//    )}
//    private val userArrayList: ArrayList<UserDataClass> = arrayListOf()
//   // private val disposable: CompositeDisposable = CompositeDisposable()
//
//    fun refresh() {
//        //fetchDataFromApi()
//        fetchUserDataFromApi()
//    }
//
//    private fun fetchUserDataFromApi() {
//        val user = userService.userInstance.getUserData()
//        user.enqueue(object : Callback<List<UserDataClass>> {
//            override fun onFailure(call: Call<List<UserDataClass>>, t: Throwable) {
//                Log.d("TAGGY", "error in fetching news", t)
//            }
//
//            override fun onResponse(call: Call<List<UserDataClass>>, response: Response<List<UserDataClass>>) {
//                Log.d("TAG", "success in fetching news")
//                    val userList: List<UserDataClass>? = response.body()
//                    if (userList != null) {
//                        userArrayList.addAll(userList)
//                        userAdapter.updateUserList(userList)
//                }
//            }
//        })
//    }

//    fun fetchDataFromApi() {
//        disposable.add(
//            userService.getUsers()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object :DisposableSingleObserver<List<UserDataClass>>() {
//                    override fun onSuccess(userList: List<UserDataClass>) {
//                        users.value = userList
//                    }
//
//                    override fun onError(e: Throwable) {
//                        e.printStackTrace()
//                    }
//
//                })
//        )
//    }

//    override fun onCleared() {
//        super.onCleared()
//        disposable.clear()
//    }

//class UserViewModel constructor(private val mainRepository: Repository) : ViewModel() {
//    var userLiveData = MutableLiveData<List<UserDataClass>>()

//    private val users: ArrayList<UserDataClass> = arrayListOf()
//    fun getUserData() {
//        val user = mainRepository.getAllUserData()
//        user.enqueue(object: Callback<List<UserDataClass>> {
//            override fun onResponse(
//                call: Call<List<UserDataClass>>,
//                response: Response<List<UserDataClass>>
//            ) {
//                if(response.isSuccessful) {
//                    val userList: List<UserDataClass>? = response.body()
//                    if(userList != null) {
//                        users.addAll(userList)
//                        userLiveData.postValue(response.body())
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<UserDataClass>>, t: Throwable) {
//                Log.d("ERROR", "onFailure: error in fetching user data")
//            }
//        })
//    }
//
//    fun observeUserLiveData() : LiveData<List<UserDataClass>> {
//        return userLiveData
//    }