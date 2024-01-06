package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.R
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses.CategoryData
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.viewmodel.RecipeViewModel

@Composable
fun RecipeScreen(
    navHostController: NavHostController,
    viewState: RecipeViewModel.RecipeState,
    senData: (CategoryData) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.isLoding -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center), color = colorResource(
                        id = R.color.orange
                    )
                )
            }

            viewState.error != null -> {
                Text("ERROR OCCURRED")
            }

            else -> {

                LazyColumn(Modifier.fillMaxSize()) {
                    items(viewState.list) {
                        RecipeItems(recipelist = it, senData)
                    }
                }
            }
        }
    }
}


@Composable
fun RecipeItems(recipelist: CategoryData, senData: (CategoryData) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .border(
                border = BorderStroke(1.dp, color = colorResource(id = R.color.orange)),
                shape = RoundedCornerShape(10)
            )
            .padding(10.dp)
            .clickable {
                senData(recipelist)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(model = recipelist.strCategoryThumb, contentDescription = null)
        recipelist.strCategory?.let { Text(text = it, textAlign = TextAlign.Center) }
    }
}