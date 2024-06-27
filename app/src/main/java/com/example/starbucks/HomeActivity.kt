package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starbucks.ui.theme.StarbucksTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomeScreen(onClickDrink = {
                        navigateToDrinkDetail()
                    })
                }
            }
        }
    }
    private fun navigateToDrinkDetail() {
        startActivity(Intent(this, DrinkDetailActivity::class.java))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClickDrink: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Menu", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        var searchText by remember { mutableStateOf("") }
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            textStyle = TextStyle(fontSize = 18.sp),
            placeholder = { Text("Search...") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24), // Replace with your search icon
                    contentDescription = null, // Content description for accessibility
                    tint = Color.Gray // Tint color for the icon
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.tertiary, shape = MaterialTheme.shapes.small)
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp)),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Promotion", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        PromotionCard()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Popular", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        PopularDrinks(onClickDrink = {onClickDrink()})
    }
}

@Composable
fun PromotionCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Today's Offer", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Free Bottle Of Coffee Latte on all orders above Rp.200.000")
        }
    }
}

@Composable
fun PopularDrinks(onClickDrink: () -> Unit) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            DrinkCard(name = "Creamy Latte", price = "Rp. 40.000") { onClickDrink() }
            DrinkCard(name = "Cappucino Latte", price = "Rp. 50.000") { onClickDrink() }
        }
    }
}

@Composable
fun DrinkCard(name: String, price: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(190.dp)
            .padding(8.dp)
            .clickable { onClick() },
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.drink_placeholder),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = price, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
