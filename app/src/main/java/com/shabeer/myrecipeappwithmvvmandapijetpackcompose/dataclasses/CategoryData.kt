package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryData(val idCategory : String? = null,
    val strCategory : String? = null,
    val strCategoryThumb : String? = null,
    val strCategoryDescription : String? = null) : Parcelable

data class Category(val categories : List<CategoryData>)
