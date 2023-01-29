package com.example.discountapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.discountapp.data.Product
import com.example.discountapp.ui.theme.DiscountAppTheme
import com.example.discountapp.ui.theme.Shoes

class Products : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiscountAppTheme {
                MyApp{
                    startActivity(ProductProfile.newIntent(this,it))
                }
                }
            }
        }
    }


@Composable
fun MyApp(navigateToProfile:(Product)-> Unit) {
    Scaffold(
        content = {
            Shoes(navigateToProfile = navigateToProfile)
        }
    )
}