package com.example.discountapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.discountapp.data.Product
import com.example.discountapp.ui.theme.Shoes
import java.lang.reflect.Modifier
import java.security.AccessControlContext

class ProductProfile : AppCompatActivity() {

    private val  product: Product by lazy {
        intent?.getSerializableExtra(PRODUCT_ID) as Product
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen(product = product)
        }

    }
    companion object{
        private const val PRODUCT_ID = "product_id"
        fun newIntent(context: Context, product: Product) =
            Intent(context,ProductProfile::class.java).apply {
                putExtra(PRODUCT_ID,product)
            }
    }
}

