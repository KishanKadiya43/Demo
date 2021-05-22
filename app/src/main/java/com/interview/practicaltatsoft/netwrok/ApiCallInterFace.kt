package com.interview.practicaltatsoft.netwrok

import android.telecom.Call
import com.interview.practicaltatsoft.model.Response
import retrofit2.http.GET


interface ApiCallInterFace {

    @GET("api/users?page=1")
    fun doGetListResources(): retrofit2.Call<Response>

}