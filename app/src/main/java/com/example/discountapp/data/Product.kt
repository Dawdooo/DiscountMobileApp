package com.example.discountapp.data

import java.io.Serializable

data class Product(val id: Int,
                    val title: String,
                    val price: Int,
                   val code: String,
                    val link: String,
                    val image: Int = 0
):Serializable