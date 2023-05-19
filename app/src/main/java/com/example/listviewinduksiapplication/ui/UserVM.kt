package com.example.listviewinduksiapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listviewinduksiapplication.ui.modal.DataUser

class UserVM : ViewModel() {
    private val vmData = MutableLiveData<List<DataUser>>()
    val vmDatas: LiveData<List<DataUser>> get() = vmData

    init {
        vmData.value = emptyList()
    }

    fun initList( list : List<DataUser>){
        vmData.value = list
    }

    fun addNew(data: DataUser){
        val newList = vmData.value!!.toMutableList() // bikin list baru dari _vm data hanya untuk bantu nge-add
        newList.add(data)
        vmData.value = newList // update livedata (_vmdata) pake newlist yang baru
    }
}