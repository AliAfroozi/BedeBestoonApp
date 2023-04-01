package com.example.bedebestoon.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.ui.components.products.*
import com.example.bedebestoon.ui.components.sliders.SliderListView
import com.example.bedebestoon.viewmodel.product.ProductViewModel

@Composable
fun HomeScreen(
    productViewModel: ProductViewModel = hiltViewModel(),
    onNavigateToProductDetail: (id : Long) -> Unit
) {
    var productList by remember { mutableStateOf(productViewModel.productList) }

    LazyColumn(modifier = Modifier.padding(5.dp, 5.dp)) {

        item {
            SliderListView()
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            CategoriesListView()
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        productItems(productList , onNavigateToProductDetail)
    }
}

fun LazyListScope.productItems(
    productList: MutableState<List<Product>>,
    onNavigateToProductDetail: (id: Long) -> Unit
) {
    item {
        ProductsListView()
    }
    items(productList.value.size) { index ->
        ProductItemView(productList.value[index]  , onNavigateToProductDetail)
        Spacer(modifier = Modifier.height(10.dp))
    }
}


