package com.example.bedebestoon.ui.components.products

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.ui.components.Loading
import com.example.bedebestoon.viewmodel.product.ProductCategoryViewModel

@Composable
fun CategoriesListView(navController: NavHostController , productCategoryViewModel: ProductCategoryViewModel = hiltViewModel()) {
    val productCategoryList by remember { mutableStateOf(productCategoryViewModel.productCategoryList) }
    val isLoading by remember { mutableStateOf(productCategoryViewModel.isLoading) }

    if (isLoading.value) {
        Loading(
            Modifier
                .width(160.dp)
                .height(200.dp), 3, 10.dp)
    } else {
        LazyRow() {
            items(productCategoryList.value.size, itemContent = { index ->
                CategoryItemView(productCategoryList.value[index] , navController)
                Spacer(modifier = Modifier.width(10.dp))
            })
        }
    }
}