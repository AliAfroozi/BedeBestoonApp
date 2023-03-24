package com.example.bedebestoon.ui.components.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductsListView() {
    Column() {
        ProductByFilterView()
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn {
            items(1) {
                ProductItemView()
            }
        }
    }
}
