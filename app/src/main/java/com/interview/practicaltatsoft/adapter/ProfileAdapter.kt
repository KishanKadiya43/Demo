package com.interview.practicaltatsoft.adapter

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.interview.practicaltatsoft.R
import com.interview.practicaltatsoft.databinding.ItemOfProfileBinding
import com.interview.practicaltatsoft.model.DataItem


class ProfileAdapter(data: ArrayList<DataItem>, requireContext: Context) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {


    private lateinit var datas: ArrayList<DataItem>
    private lateinit var context: Context
    private val LOADING = 0
    private val ITEM = 1
    private val isLoadingAdded = false

    fun setProfileList(movieList: ArrayList<DataItem>) {
        this.datas = movieList
    }


    init {
        this.datas = data
        this.context = requireContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding =
            ItemOfProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datas.size
    }


    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val data = datas.get(position)
        holder.binding.txtName.text = data.firstName + " " + data.lastName
        holder.binding.txtEmail.text = data.email
        Glide.with(context).load(data.avatar).placeholder(R.mipmap.ic_launcher)
            .into(holder.binding.circleImageView)
    }


    inner class ProfileViewHolder(internal var binding: ItemOfProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }
}