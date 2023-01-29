package com.example.discountapp.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.discountapp.ShoesListItem
import com.example.discountapp.data.DataProvider
import com.example.discountapp.data.Product

@Composable
fun Shoes(navigateToProfile:(Product)-> Unit) {
    val shoes = remember { DataProvider.productsList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = shoes,
            itemContent = {
                ShoesListItem(product = it, navigateToProfile)
            })
    }
}