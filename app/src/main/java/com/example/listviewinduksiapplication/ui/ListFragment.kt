package com.example.listviewinduksiapplication.ui

import android.os.Bundle
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
    private lateinit var mainRecyclerView: RecyclerView
    private lateinit var mainAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
        subscribe()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initUI()
        binding.apply {
            listUser.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    fun initViewModel(){
        userVM = ViewModelProvider(this)[UserVM::class.java]
    }

    fun subscribe(){
        userVM.vmDatas.observe(viewLifecycleOwner){ vmDatas ->
            mainAdapter = ListAdapter(vmDatas)
            mainRecyclerView.adapter = mainAdapter
        }
    }

    fun initUI(){
        val listUser = mutableListOf<DataUser>(
            DataUser("Rani","Nurani"),
            DataUser("Aldi","aldis"),
            DataUser("Humam","humem"),
            DataUser("Condro","condros"),
            DataUser("Alfi","alfis")
        )
        userVM.initList(listUser)
        binding.apply {
            if (etFirstName.text.toString().isNotBlank() && etLastName.text.toString().isNotBlank()){
                userVM.addNew(DataUser(etFirstName.toString(),etLastName.toString()))
                etFirstName.text.clear()
                etLastName.text.clear()
                mainAdapter.notifyItemInserted(userVM.vmDatas.value!!.size -1)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment()
    }
}