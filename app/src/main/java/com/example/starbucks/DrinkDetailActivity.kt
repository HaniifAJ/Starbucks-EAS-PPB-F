package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.starbucks.ui.theme.StarbucksTheme

class DrinkDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    DrinkDetailScreen(onClickShop = {
                        navigateToShoppingCart()
                    })
                }
            }
        }
    }

    private fun navigateToShoppingCart() {
        startActivity(Intent(this, ShoppingCartActivity::class.java))
    }
}

@Composable
fun DrinkDetailScreen(onClickShop: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.drink_placeholder),
            contentDescription = null,
            modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Creamy Latte", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Rp. 40.000", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Rating: 4.5", style = MaterialTheme.typography.bodySmall)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Handle remove item */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_remove_24),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
                Text(text = "1", style = MaterialTheme.typography.bodySmall)
                IconButton(onClick = { /* TODO: Handle add item */ }) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Add Ons", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        AddOns()
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onClickShop() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add to Cart")
        }
    }
}

@Composable
fun AddOns() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AddOnItem(name = "Syrup")
        AddOnItem(name = "Cheese")
        AddOnItem(name = "Jelly")
    }
}

@Composable
fun AddOnItem(name: String) {
    Card(
        modifier = Modifier.size(100.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.addon_placeholder),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, style = MaterialTheme.typography.bodySmall)
        }
    }
}
