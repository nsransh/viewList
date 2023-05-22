package com.example.listviewinduksiapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listviewinduksiapplication.ui.modal.DataUser

class UserVM : ViewModel() {
    private val _listUser = MutableLiveData<List<DataUser>>()
    val vmDatas: LiveData<List<DataUser>> get() = _listUser

    init {
        _listUser.value = emptyList()
    }

    fun initList( list : List<DataUser>){
        _listUser.value = list
    }

    fun addNew(data: DataUser){
        val newList = _listUser.value!!.toMutableList() // bikin list baru dari _listUser data hanya untuk bantu nge-add
        newList.add(data)
        _listUser.value = newList // update livedata (_listUser) pake newlist yang baru
    }
}
