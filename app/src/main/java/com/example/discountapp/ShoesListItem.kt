package com.example.discountapp

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.media.Image
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.example.discountapp.data.Product
import kotlinx.coroutines.processNextEventInCurrentThread
import org.w3c.dom.Text

@Composable
fun ShoesListItem(product: Product,navigateToProfile:(Product)-> Unit) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
    backgroundColor = Color.White,shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        @Composable
        fun ProductImage(product: Product){
            androidx.compose.foundation.Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(
                        RoundedCornerShape(corner = CornerSize(16.dp))
                    ))
        }

        Row (
            Modifier.clickable { navigateToProfile(product)}
                ){
            ProductImage(product)
            Column (modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
            ){
                Text(text = product.title, style = typography.h6)
                Text(text = product.price.toString(),style = typography.caption)
            }
    }

}
}