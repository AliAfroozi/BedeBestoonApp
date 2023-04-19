package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.ui.components.products.ProductItemView
import com.example.bedebestoon.viewmodel.product.ProductByCategoryViewModel
import com.example.bedebestoon.viewmodel.product.ProductCategoryViewModel
import com.example.bedebestoon.viewmodel.product.ProductViewModel

@Composable
fun ProductsScreen(
    navController: NavHostController,
    categoryId : Long?,
    categoryTitle: String?,
    productViewModel: ProductByCategoryViewModel = hiltViewModel()
) {

    var productList by remember { mutableStateOf(productViewModel.productByCategoryList) }
    var isLoading by remember { mutableStateOf(productViewModel.isLoading) }

    LazyColumn() {
        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp)
            ) {
                Text(
                    text = categoryTitle!!,
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        items(productList.value.size) { index ->
            ProductItemView(productList.value[index], navController)
            productViewModel.onScrollPositionChange(index)

            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            if (isLoading.value) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(40.dp) , color = Color.Gray)
                }
            }
        }
    }
}
