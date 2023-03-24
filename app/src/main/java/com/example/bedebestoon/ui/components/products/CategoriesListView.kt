package com.example.bedebestoon.ui.components.products

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bedebestoon.viewmodel.product.ProductCategoryViewModel

@Composable
fun CategoriesListView(productCategoryViewModel: ProductCategoryViewModel = hiltViewModel()) {
    val productCategoryList by remember { mutableStateOf(productCategoryViewModel.productCategoryList) }

    LazyRow() {
        items(productCategoryList.value.size, itemContent = { index ->
            CategoryItemView(productCategoryList.value[index])
            Spacer(modifier = Modifier.width(10.dp))
        })
    }
}