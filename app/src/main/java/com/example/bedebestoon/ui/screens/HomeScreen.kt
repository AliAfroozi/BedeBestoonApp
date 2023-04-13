package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.ui.components.products.*
import com.example.bedebestoon.ui.components.sliders.SliderListView
import com.example.bedebestoon.viewmodel.product.ProductViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel = hiltViewModel()
) {
    var productList by remember { mutableStateOf(productViewModel.productList) }
    productViewModel.getAllProducts {
        if (it.status == "OK"){
            productViewModel.productList.value = it.data!!
        }
    }
    LazyColumn(modifier = Modifier.padding(5.dp, 5.dp)) {

        item {
            SliderListView()
        }
        item {
            Spacer(modifier = Modifier.height(15.dp))
        }

        item {
            CategoriesListView(navController)
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
        }

        productItems(productList , navController)
    }
}

fun LazyListScope.productItems(
    productList: MutableState<List<Product>>,
    navController : NavHostController
) {
    item {
        ProductsListView()
    }
    items(productList.value.size) { index ->
        ProductItemView(productList.value[index]  , navController)
        Spacer(modifier = Modifier.height(10.dp))
    }
}


