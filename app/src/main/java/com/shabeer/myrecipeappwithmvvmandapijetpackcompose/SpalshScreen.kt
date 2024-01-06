package com.shabeer.myrecipeappwithmvvmandapijetpackcompose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shabeer.myrecipeappwithmvvmandapijetpackcompose.ui.theme.MyRecipeAppWIthMVVMAndAPIJetpackComposeTheme
import kotlinx.coroutines.delay

class SpalshScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LaunchedEffect(key1 = Unit) {
                Handler(Looper.getMainLooper()).postDelayed({
                    val dashBord = Intent(this@SpalshScreen, MainActivity::class.java)
                    startActivity(dashBord)
                }, 3000)


            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    Modifier.size(150.dp)
                )
            }
        }
    }
}
