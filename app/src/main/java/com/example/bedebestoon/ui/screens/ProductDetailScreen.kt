package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.db.models.BasketEntity
import com.example.bedebestoon.db.viewModels.BasketEntityViewModel
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.ui.components.Loading
import com.example.bedebestoon.viewmodel.product.ProductViewModel
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    productId: Long?,
    basketEntityViewModel: BasketEntityViewModel,
    productViewModel: ProductViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    var productInfo = remember {
        mutableStateOf(productViewModel.productInfo)
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    productId?.let { it ->
        productViewModel.getProductById(it) { response ->
            if (response.status == "OK") {
                productViewModel.productInfo.value = response.data!!
                isLoading = false
            }
        }
    }

    if (isLoading) {
        Loading(
            Modifier
                .fillMaxWidth()
                .height(250.dp), count = 1, heightSpacer = 15.dp
        )
    } else {
        Box() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(545.dp),
                shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp)
            )
            {
                GlideImage(
                    modifier = Modifier.fillMaxSize(),
                    imageModel = { if (productInfo.value.value.isNotEmpty()) productInfo.value.value[0].image!! else "" },
                    loading = {
                        Box(modifier = Modifier.fillMaxSize()) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(30.dp, 30.dp),
                                color = Color.LightGray
                            )
                        }
                    },
                    // shows an error text if fail to load an image.
                    failure = {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            textAlign = TextAlign.Center,
                            text = "image request failed.", fontSize = 10.sp
                        )
                    }
                )
            }
        }

        Box(contentAlignment = Alignment.TopStart) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 5.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }

                IconButton(onClick = {  /* ToDo : go to shop cart page */ }) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        ) {

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 10.dp, 5.dp, 20.dp), contentAlignment = Alignment.BottomStart
        ) {

            Column {
                TitleAndPrice(product = productInfo.value.value[0])
                Spacer(modifier = Modifier.height(15.dp))
                val selectedSize = Sizes(productInfo.value.value[0])
                Spacer(modifier = Modifier.height(15.dp))
                val selectedColor = ColorsRow(productInfo.value.value[0])
                Spacer(modifier = Modifier.height(30.dp))
                AddToCart(
                    basketEntityViewModel,
                    productInfo.value.value[0],
                    selectedSize,
                    selectedColor
                )
            }
        }
    }
}

@Composable
fun Sizes(product: Product?): Int {

    var selectedSize by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.padding(start = 12.dp)
    ) {
        Text(
            text = "Sizes",
            style = MaterialTheme.typography.h1,
            color = Color.White,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow(
        ) {
            items(product!!.sizes!!.size) { index ->
                TextButton(
                    onClick = { selectedSize = index },
                    modifier = Modifier.size(40.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (index == selectedSize) Color.White else Color.Transparent)
                ) {
                    Text(
                        text = product.sizes!![index].value.toString(),
                        color = if (index == selectedSize) Color.Black else Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
    return selectedSize
}

@Composable
fun ColorsRow(product: Product?): Int {
    var selectedColor by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.padding(start = 12.dp)
    ) {
        Text(
            text = "Colors",
            style = MaterialTheme.typography.h1,
            color = Color.White,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(5.dp))

        LazyRow(
        ) {
            items(product!!.colors!!.size) { index ->
                TextButton(
                    onClick = { selectedColor = index },
                    modifier = Modifier.size(40.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(
                            android.graphics.Color.parseColor(
                                "#" + product.colors!![index].hexValue
                            )
                        )
                    ),
                    border = if (selectedColor == index && product.colors!![index].hexValue == "FFFFFF") BorderStroke(
                        1.dp,
                        Color.Black
                    ) else if (selectedColor == index) BorderStroke(
                        1.dp,
                        Color.White
                    ) else BorderStroke(
                        0.dp,
                        Color.Transparent
                    )
                ) {
                    if (selectedColor == index)
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "",
                            tint = if (product.colors!![index].hexValue == "FFFFFF") Color.Black else Color.White
                        )
                }
                Spacer(modifier = Modifier.width(7.dp))
            }
        }
    }
    return selectedColor
}


@Composable
fun TitleAndPrice(product: Product?) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 30.dp)
    ) {
        Column() {

            Text(
                text = if (product != null) product.title!! else "Fail in collecting product data from internet.",
                color = Color.White,
                style = MaterialTheme.typography.h1
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = if (product != null) product.category!!.title!! else "Fail in collecting product data from internet.",
                fontSize = 15.sp,
                color = Color.White,
                style = MaterialTheme.typography.body1
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = if (product != null) product.price!! else "",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }


}

@Composable
fun AddToCart(
    basketEntityViewModel: BasketEntityViewModel,
    product: Product,
    selectedSize: Int,
    selectedColor: Int
) {

    Button(
        onClick = {
            var basketItem = BasketEntity(
                productId = product.id!!,
                price = product.price!!,
                image = product.image!!,
                title = product.title!!,
                quantity = 1,
                colorId = product.colors!![selectedColor].id!!,
                sizeId = product.sizes!![selectedSize].id!!
            )
            CoroutineScope(Dispatchers.IO).launch {
                basketEntityViewModel.addToBasket(basketItem)
            }
        },
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = com.example.bedebestoon.ui.theme.AddToCart,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "Buy Now",
            style = MaterialTheme.typography.button,
            fontWeight = FontWeight.Bold
        )
    }
}

