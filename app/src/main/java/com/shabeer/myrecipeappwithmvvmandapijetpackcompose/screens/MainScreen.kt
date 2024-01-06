package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.R
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses.CategoryData
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.navigationScreens.Screens
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.viewmodel.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Recipe App") }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = colorResource(
            id = R.color.orange
        )))
    }) {
        Box(modifier = Modifier.padding(it)){
          ItemsList()
        }
    }

}



@Composable
fun ItemsList() {
    val viewModel: RecipeViewModel = viewModel()
    val viewstate by viewModel.recipeState
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screens.recipeScreen.route) {
        composable(Screens.recipeScreen.route) {
            RecipeScreen(navHostController = navHostController, viewState = viewstate, senData = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("recipe", it)
                navHostController.navigate(Screens.recipeDetailsScreen.route)
            })
        }

        composable(Screens.recipeDetailsScreen.route) {
           val category =  navHostController.previousBackStackEntry?.savedStateHandle?.get<CategoryData>("recipe")
                ?: CategoryData("", "", "")
            RecipeDetailsScreen(category)
        }
    }
}