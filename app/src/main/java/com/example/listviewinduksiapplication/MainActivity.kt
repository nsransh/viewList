package com.example.listviewinduksiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.listviewinduksiapplication.databinding.FragmentListBinding
import com.example.listviewinduksiapplication.ui.ListAdapter
import com.example.listviewinduksiapplication.ui.UserVM
import com.example.listviewinduksiapplication.ui.modal.DataUser


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}