package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.navigationScreens

sealed class Screens (val route : String) {
    object recipeScreen : Screens("recipeScreen")
    object recipeDetailsScreen : Screens("recipeDetailsScreen")
}