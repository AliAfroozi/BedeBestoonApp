package com.example.bedebestoon.ui.components.products
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.product.ProductCategory
import com.example.bedebestoon.ui.components.Loading
import com.example.bedebestoon.utils.ThisApp
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItemView(productCategory: ProductCategory, navController: NavHostController) {
    Card(
        modifier = Modifier
            .size(160.dp, 200.dp)
            .shadow(8.dp, RoundedCornerShape(30.dp), clip = true),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            ThisApp.productCategoryId = productCategory.id!!
            navController.navigate("products_screen/${productCategory.id}/${productCategory.title}")
        }
    ) {
        Box() {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = { productCategory.image },
                // shows an error text if fail to load an image.
                failure = {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "image request failed."
                    )
                }
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = productCategory.title!!,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}
