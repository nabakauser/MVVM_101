package com.example.mvvm_101

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_101.model.UserDataClass

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {
    private var userList = ArrayList<UserDataClass>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.id.text = userList[position].id.toString()
        holder.title.text = userList[position].title
        holder.body.text = userList[position].body
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList : List<UserDataClass>) {
        this.userList = userList as ArrayList<UserDataClass>
        userList.clear()
        userList.addAll(userList)
        notifyDataSetChanged()
    }

}

class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val id: TextView = view.findViewById(R.id.uiTvId)
    val title: TextView = view.findViewById(R.id.uiTvTitle)
    val body: TextView = view.findViewById(R.id.uiTvBody)
}