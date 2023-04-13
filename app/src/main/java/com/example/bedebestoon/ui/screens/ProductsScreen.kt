package com.example.bedebestoon.viewmodel.product

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.ui.components.products.ProductItemView
import com.example.bedebestoon.ui.components.products.ProductsListView

@Composable
fun ProductsScreen(
    navController: NavHostController,
    productCategory: Long?,
    categoryTitle: String?,
    productViewModel: ProductViewModel = hiltViewModel()
) {

    var productList by remember { mutableStateOf<List<Product>>(listOf()) }
    var isLoading by remember { mutableStateOf(true) }
    
    if (productCategory != null) {
        productViewModel.getByCategoryId(productCategory , 10 , 0) { response ->
            isLoading = false
            if (response.status == "OK")
            productList = response.data!!
        }
    }



    if (isLoading){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.size(90.dp))
        }

    }else{
        LazyColumn() {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth().padding(0.dp , 10.dp)
                ) {
                    Text(text = categoryTitle!! , style = MaterialTheme.typography.h1 , textAlign = TextAlign.Center)
                }

                Spacer(modifier = Modifier.height(10.dp))
            }

                items(productList.size) { index ->
                    ProductItemView(productList[index]  , navController)
                    Spacer(modifier = Modifier.height(10.dp))
                }
        }
    }
}
