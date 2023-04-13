package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    var fullScreen by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            if (!fullScreen)
                TopAppBarView()
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(contentPadding)
        )
        {
            composable("home") {
                fullScreen = false
                HomeScreen(navController)

            }

            composable(
                "product_detail/{product_id}",
                arguments = listOf(navArgument("product_id") { type = NavType.LongType })
            ) {
                val productId = it.arguments?.getLong("product_id")
                fullScreen = true
                ProductDetailScreen(navController, productId)
            }

            composable(
                "products_screen/{product_category_id}/{title}",
                arguments = listOf(navArgument("product_category_id") { type = NavType.LongType } , navArgument("title") { type = NavType.StringType })
            ) {
                fullScreen = true
                val productCategory = it.arguments?.getLong("product_category_id")
                val categoryTitle = it.arguments?.getString("title")
                ProductsScreen(navController, productCategory , categoryTitle)
            }
        }
    }
}