package com.example.bedebestoon.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Loading(modifier: Modifier, count: Int, widthSpacer: Dp = 0.dp, heightSpacer: Dp = 0.dp) {
    if (count == 1) {
        LoadingCard(modifier)
    } else {
        LazyRow {
            items(count) {
                LoadingCard(modifier)
                Spacer(modifier = Modifier.width(widthSpacer))
                Spacer(modifier = Modifier.height(heightSpacer))
            }
        }
    }
}

@Composable
fun LoadingCard(modifier: Modifier) {
    Card(
        modifier = modifier
            .shadow(8.dp, RoundedCornerShape(30.dp), clip = true),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}