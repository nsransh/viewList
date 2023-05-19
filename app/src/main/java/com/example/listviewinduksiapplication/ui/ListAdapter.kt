package com.example.listviewinduksiapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewinduksiapplication.R
import com.example.listviewinduksiapplication.databinding.CardContentListBinding
import com.example.listviewinduksiapplication.ui.modal.DataUser

class ListAdapter(private val data: List<DataUser>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = CardContentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ListViewHolder(val binding: CardContentListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataUser: DataUser){
            binding.apply {
                ivProfile.setImageDrawable(itemView.context.getDrawable(R.drawable.pawprint))
                tvFirstName.text = dataUser.firstName
                tvLastName.text = dataUser.lastName
            }
        }
//        val tvFirstName = binding.tvFirstName
//        val tvLastName = binding.tvLastName
    }
}