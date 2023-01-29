package com.example.discountapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.discountapp.data.Product

@Composable

fun ProfileScreen(product: Product){
    val scrollState = rememberScrollState()
    
    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints{
           Surface{
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)) {
 ProfileHeader(product,this@BoxWithConstraints.maxHeight)
                    Title(product,this@BoxWithConstraints.maxHeight)
                }
            }
        }
        
    }
}
@Composable
private fun ProfileHeader(
    product: Product,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = product.image),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
@Composable
fun Title(product: Product, maxHeight: Dp){
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(product.link)) }
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = product.title,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,modifier = Modifier
                .padding(8.dp)
        )
        Text("Price: ${product.price}zł",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Normal,modifier = Modifier
                .padding(8.dp))

        Text("discount code: ${product.code}",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Normal,modifier = Modifier
                .padding(8.dp))

        TextButton(onClick = {context.startActivity(intent)}) {
            Text("website",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Normal, color = Color.Blue)
        }
        }

}
