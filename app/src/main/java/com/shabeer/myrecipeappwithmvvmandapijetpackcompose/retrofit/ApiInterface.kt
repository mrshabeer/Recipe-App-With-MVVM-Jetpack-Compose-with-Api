package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.retrofit

import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses.Category
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/json/v1/1/categories.php")
    suspend fun loadRecipeData () : Category
}