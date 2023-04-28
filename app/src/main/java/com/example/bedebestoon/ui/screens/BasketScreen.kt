package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bedebestoon.MainActivity
import com.example.bedebestoon.db.viewModels.BasketEntityViewModel
import com.example.bedebestoon.ui.components.basket.BasketListItem
import com.example.bedebestoon.ui.theme.Dark

@Composable
fun BasketScreen(
    basketEntityViewModel: BasketEntityViewModel,
    navController: NavHostController
) {
    val basketList by remember {
        mutableStateOf(basketEntityViewModel.basketListLive)
    }



    Box() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Row(
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column() {
                        Text(text = "Shopping Cart", style = MaterialTheme.typography.h2)
                        Spacer(modifier = Modifier.height(8.dp))
                        if (basketList.value.isNotEmpty()) {
                            Text(
                                text = if (basketList.value.size == 1) "${basketList.value.size} item" else "${basketList.value.size} items",
                                style = MaterialTheme.typography.body1,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Light,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }


            if (basketList.value.isEmpty()) {
                item {
                    val screenHeight = LocalConfiguration.current.screenHeightDp / 3
                    Spacer(modifier = Modifier.height(screenHeight.dp))
                }
                item {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "",
                                modifier = Modifier.size(70.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Your shopping cart is empty.", fontSize = 16.sp)
                        }
                    }
                }
            } else {
                items(count = basketList.value.size) { index ->
                    BasketListItem(
                        basketList.value[index],
                        basketEntityViewModel,
                        navController
                    )

                    if (index == basketList.value.size -1 ){
                        Spacer(modifier = Modifier.height(130.dp))
                    }
                }

                item {

                }
            }
        }

        if (basketList.value.isNotEmpty()) {
            Box(contentAlignment = Alignment.BottomCenter , modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)) {

                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Dark),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth()
                        .height(50.dp)) {
                    Text(
                        text = "Complete your purchase",
                        color = Color.White,
                        style = MaterialTheme.typography.button,
                        fontSize = 16.sp
                    )
                }

            }
        }
    }


}