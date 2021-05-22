package com.interview.practicaltatsoft

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.interview.practicaltatsoft.adapter.ProfileAdapter
import com.interview.practicaltatsoft.databinding.ActivityTaskTwoBinding
import com.interview.practicaltatsoft.model.DataItem
import com.interview.practicaltatsoft.model.Response
import com.interview.practicaltatsoft.netwrok.ApiCallInterFace
import com.interview.practicaltatsoft.netwrok.ApiHelperClass
import retrofit2.Call

class Task_Two_Activity : AppCompatActivity() {


    lateinit var binding: ActivityTaskTwoBinding
    lateinit var data: ArrayList<DataItem>
    lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task__two_)
        apiCall()
    }

    private fun apiCall() {
        val movieService: ApiCallInterFace? =
            ApiHelperClass.getRetrofitIns()!!.create(ApiCallInterFace::class.java) //1

        movieService?.doGetListResources()!!.enqueue(object : retrofit2.Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {

            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {


                if (response != null) {
                    if (response.isSuccessful) {
                        data = response.body().data as ArrayList<DataItem>
                        adapter = ProfileAdapter(data, this@Task_Two_Activity)
                        val manager = LinearLayoutManager(this@Task_Two_Activity)
                        binding?.recyclerview?.layoutManager = manager
                        binding?.recyclerview?.adapter = adapter
                        binding?.recyclerview?.isNestedScrollingEnabled = false;

                    } else {

                    }
                } else {
                }
            }

        })
    }
}