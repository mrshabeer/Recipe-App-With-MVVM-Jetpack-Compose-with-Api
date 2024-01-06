package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofitBuilder = Retrofit.Builder().baseUrl("https://www.themealdb.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val retrofitApi : ApiInterface = retrofitBuilder.create(ApiInterface::class.java)
}