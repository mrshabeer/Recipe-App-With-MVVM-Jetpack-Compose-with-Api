package com.shabeer.myrecipeappwithmvvmandapijetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.R
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.dataclasses.CategoryData

@Composable
fun RecipeDetailsScreen(category: CategoryData) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(10.dp)
            .border(
                border = BorderStroke(
                    1.dp, color = colorResource(
                        id = R.color.orange
                    )
                ),
                shape = RoundedCornerShape(3)
            )
            .padding(10.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Recipe Name : ${category.strCategory}",
            fontSize = 20.sp,
            color = colorResource(
                id = R.color.orange
            )
        )
        Spacer(modifier = Modifier.padding(top = 15.dp))
        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(top = 15.dp))
        category.strCategoryDescription?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
                    .padding(16.dp)
            )
        }
    }
}


