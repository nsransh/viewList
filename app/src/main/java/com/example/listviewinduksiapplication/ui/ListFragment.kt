package com.example.listviewinduksiapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewinduksiapplication.databinding.FragmentListBinding
import com.example.listviewinduksiapplication.ui.modal.DataUser

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var userVM: UserVM
    private lateinit var mainAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userVM = ViewModelProvider(requireActivity())[UserVM::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUserViewModel()
        mainAdapter = ListAdapter(userVM.vmDatas.value!!)
        binding.apply {
            listUser.layoutManager = LinearLayoutManager(requireContext())
            listUser.adapter = mainAdapter

            btnAdd.setOnClickListener {
                if (etFirstName.text.toString().isNotBlank() && etLastName.text.toString().isNotBlank()){
                    userVM.addNew(DataUser(etFirstName.text.toString(),etLastName.text.toString()))
                    etFirstName.text.clear()
                    etLastName.text.clear()
                    Log.e("list","${userVM.vmDatas.value!!.size-1}")
                    mainAdapter.notifyItemInserted(userVM.vmDatas.value!!.size-1)
//                    mainAdapter = ListAdapter(userVM.vmDatas.value!!)
                }
            }
        }
    }

    fun initUserViewModel(){
        userVM.addNew(DataUser("Rani","Nurani"))
        userVM.addNew(DataUser("Aldi","aldis"))
        userVM.addNew(DataUser("Humam","humem"))
        userVM.addNew(DataUser("Condro","condros"))
        userVM.addNew(DataUser("Alfi","alfis"))
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment()
    }
}