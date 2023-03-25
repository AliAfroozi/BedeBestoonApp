package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bedebestoon.ui.components.sliders.SliderListView
import com.example.bedebestoon.ui.components.products.CategoriesListView
import com.example.bedebestoon.ui.components.products.ProductsListView

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(5.dp, 20.dp)) {
        SliderListView()
        Spacer(modifier = Modifier.height(15.dp))
        CategoriesListView()
        Spacer(modifier = Modifier.height(20.dp))
        ProductsListView()
    }
}




