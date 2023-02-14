package com.example.mvvm_101.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_101.MainRepository
import com.example.mvvm_101.UserAdapter
import com.example.mvvm_101.data.api.UserInterface
import com.example.mvvm_101.databinding.ActivityMainBinding
import com.example.mvvm_101.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: UserViewModel
    private val adapter = UserAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = UserInterface.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.uiRvList.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(UserViewModel::class.java)


        viewModel.movieList.observe(this, {
            adapter.updateUserList(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

//        viewModel.loading.observe(this, Observer {
//            if (it) {
//                binding.progressDialog.visibility = View.VISIBLE
//            } else {
//                binding.progressDialog.visibility = View.GONE
//            }
//        })

        viewModel.getUserData()

    }
}

//class MainActivity : AppCompatActivity() {
//
//    private var binding: ActivityMainBinding? = null
//    private var viewModel: UserViewModel? = null
//    private var userListAdapter = UserAdapter()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//
//        prepareRecyclerView()
//        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
//        viewModel?.getUserData()
//        viewModel?.observeUserLiveData()?.observe(this, Observer { userList ->
//            userListAdapter.updateUserList(userList)
//        })
//    }
//
//    private fun prepareRecyclerView() {
//        userListAdapter = UserAdapter()
//        binding?.uiRvList?.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = userListAdapter
//        }
//    }
        //viewModel?.refresh()

//        binding?.uiRvList?.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = userListAdapter
//        }
//        observeViewModel()
//    }
//
//    private fun observeViewModel() {
//        viewModel?.users?.observe(this, { userList ->
//            userList?.let { userListAdapter.updateUserList(userList)}
//            Log.d("Mainn", "observeViewModel: "+ userList)
//        })
//    }
}