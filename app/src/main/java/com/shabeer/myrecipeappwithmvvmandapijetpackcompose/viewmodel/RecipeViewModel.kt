package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses.CategoryData
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.retrofit.RetrofitInstance
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _recipeState = mutableStateOf(RecipeState())
    val recipeState : State<RecipeState> = _recipeState

    init {
        getRecipeData()
    }

    private fun getRecipeData() {
        viewModelScope.launch {
            try {
                val responce = RetrofitInstance.retrofitApi.loadRecipeData()
                _recipeState.value = _recipeState.value.copy(
                    list = responce.categories,
                    isLoding = false,
                    error = null
                )
            }catch (e : Exception){
                _recipeState.value = _recipeState.value.copy(
                    isLoding = false,
                    error = "Error${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val isLoding: Boolean = true,
        val list: List<CategoryData> = emptyList(),
        val error: String? = null
    )


}