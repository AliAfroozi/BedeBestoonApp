package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bedebestoon.MainActivity
import com.example.bedebestoon.db.viewModels.BasketEntityViewModel
import com.example.bedebestoon.ui.components.basket.BasketListItem

@Composable
fun BasketScreen(
    basketEntityViewModel: BasketEntityViewModel,
    navController: NavHostController
) {
    val basketList by remember {
        mutableStateOf(basketEntityViewModel.basketListLive)
    }



    LazyColumn() {
        item {
            Row(modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column() {
                    Text(text = "Shopping Cart", style = MaterialTheme.typography.h2)
                    Spacer(modifier = Modifier.height(8.dp))
                    if (basketList.value.isNotEmpty()) {
                        Text(
                            text = if (basketList.value.size == 1) "${basketList.value.size} item" else "${basketList.value.size} items" ,
                            style = MaterialTheme.typography.body1,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray
                        )
                    }
                }
            }
        }


        if (basketList.value.isEmpty()){
            item {
                Box(modifier = Modifier.fillMaxSize() , contentAlignment = Alignment.Center) {
                    Column() {
                        Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "" , modifier = Modifier.size(70.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Your shopping cart is empty." , fontSize = 16.sp)
                    }
                }
            }
        }else{
            items(count = basketList.value.size) { index ->
                BasketListItem(basketList.value[index])
            }
        }
    }

}