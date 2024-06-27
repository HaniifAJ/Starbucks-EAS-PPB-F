package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class ShoppingCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ShoppingCartScreen(onClickHome = {
                        navigateHome()
                    }, onClickCheckout = {
                        navigateCheckout()
                    })
                }
            }
        }
    }

    private fun navigateHome(){
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun navigateCheckout(){
        startActivity(Intent(this, OrderSuccessActivity::class.java))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(onClickHome: () -> Unit, onClickCheckout: () -> Unit) {
    var discountActivated by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "2 items in cart", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        CartItem(name = "Creamy Latte", price = "Rp. 40.000")
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "Order Instruction") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        if(discountActivated){
            Text(text = "Total: Rp. 30.000", style = MaterialTheme.typography.headlineMedium)
        } else {
            Text(text = "Total: Rp. 40.000", style = MaterialTheme.typography.headlineMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Use New Member Rp 10k Promo Reward", modifier = Modifier.weight(1f))
            Switch(
                checked = discountActivated,
                onCheckedChange = { activated -> discountActivated = activated },
//                colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.primary)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onClickCheckout() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Checkout")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onClickHome() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back to Menu")
        }
    }
}

@Composable
fun CartItem(name: String, price: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = name, style = MaterialTheme.typography.bodySmall)
            Text(text = price, style = MaterialTheme.typography.bodySmall)
        }
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
}
