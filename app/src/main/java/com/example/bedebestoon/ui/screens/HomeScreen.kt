package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.otherContent.Slider
import com.example.bedebestoon.model.product.ProductCategory
import com.example.bedebestoon.ui.components.SliderListView
import com.example.bedebestoon.ui.components.products.CategoriesListView
import com.example.bedebestoon.ui.components.products.ProductsListView
import com.example.bedebestoon.viewmodel.otherContent.SliderViewModel
import com.example.bedebestoon.viewmodel.product.ProductCategoryViewModel
import com.skydoves.landscapist.glide.GlideImage

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




