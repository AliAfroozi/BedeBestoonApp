package com.example.onlineshopapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.onlineshopapp.ui.theme.OnlineShopAppTheme
import com.example.onlineshopapp.viewmodel.otherContent.SliderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShopAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowSlider()
                }
            }
        }
    }
}

@Composable
fun ShowSlider(sliderViewModel: SliderViewModel = hiltViewModel()) {
    sliderViewModel.getSliders {
        response ->
        val status = response.status
        if (status ==  "OK") {
            Log.i("SLIDER_DATA" , "${response.data}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OnlineShopAppTheme {
    }
}