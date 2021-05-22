package com.interview.practicaltatsoft.netwrok

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelperClass {

    companion object {

        private var apiInterface: ApiCallInterFace? = null

        var Base_Url = "https://reqres.in/"
        private var retrofit: Retrofit? = null


        fun getRetrofitIns(): Retrofit? {
            var interceptor = HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            var client = OkHttpClient.Builder().addInterceptor(interceptor).build();


            retrofit = Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



            return retrofit;
        }

    }
}
