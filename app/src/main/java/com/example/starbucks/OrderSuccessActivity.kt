package com.example.starbucks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.starbucks.ui.theme.StarbucksTheme

class OrderSuccessActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    OrderSuccessScreen()
                }
            }
        }
    }
}

@Composable
fun OrderSuccessScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Displaying the check circle icon
        Icon(
            painterResource(id = R.drawable.baseline_check_circle_24),
            null,
            Modifier.size(150.dp),
            MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Text indicating "Order Success"
        Text(
            text = "Order Success",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderSuccessScreen() {
    OrderSuccessScreen()
}
