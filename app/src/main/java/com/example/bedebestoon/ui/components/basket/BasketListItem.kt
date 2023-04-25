package com.example.bedebestoon.ui.components.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.ui.core.VerticalAlignmentLine
import com.example.bedebestoon.R
import com.example.bedebestoon.db.models.BasketEntity
import com.example.bedebestoon.viewmodel.product.ProductColorViewModel
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun BasketListItem(
    basketItem: BasketEntity,
    productColorViewModel: ProductColorViewModel = hiltViewModel()
) {

    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Card(
                modifier = Modifier
                    .size(120.dp, 120.dp)
                    .shadow(elevation = 8.dp, RoundedCornerShape(20.dp), clip = true),
                shape = RoundedCornerShape(20.dp)
            )
            {
                GlideImage(
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp),
                    imageModel = { basketItem.image },
                    loading = {
                        Box(
                            modifier = Modifier
                                .width(60.dp)
                                .height(60.dp)
                        ) {
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


            Spacer(modifier = Modifier.width(16.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(text = basketItem.title , style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = CenterVertically) {
                    Text(text = basketItem.price , style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.width(16.dp))
                    Card(
                        modifier = Modifier.size(30.dp),
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(
                            android.graphics.Color.parseColor(
                                "#${basketItem.colorHex}"
                            )
                        ),
                        content = {}
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier.padding(end = 12.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        IconButton(onClick = { /*TODO : decrease quantity */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_baseline_remove_24),
                                contentDescription = ""
                            )
                        }

                        Text(text = basketItem.quantity.toString() , fontSize = 18.sp)

                        IconButton(onClick = { /*TODO : increase quantity */ }) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                        }

                        IconButton(onClick = { /*TODO : delete basketItem */ }) {
                            Icon(imageVector = Icons.Filled.Delete, contentDescription = "" , tint = Color.Red)
                        }

                    }

            }

        }

    }

}