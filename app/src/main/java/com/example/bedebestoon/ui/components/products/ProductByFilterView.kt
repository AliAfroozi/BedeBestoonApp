package com.example.bedebestoon.ui.components.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProductByFilterView() {
    val filters = listOf("All", "New", "Popular")
    var selectedFilter by remember { mutableStateOf(0) }
    LazyRow {
        items(filters.size) { index ->

            TextButton(
                onClick = { selectedFilter = index },
                modifier = Modifier
                    .padding(5.dp, 0.dp)
                    .width(80.dp)
                    .selectable(index== selectedFilter , true , null) {},
                colors = ButtonDefaults.buttonColors(backgroundColor = if (index == selectedFilter) Color.LightGray else Color.Transparent),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = filters[index],
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}
