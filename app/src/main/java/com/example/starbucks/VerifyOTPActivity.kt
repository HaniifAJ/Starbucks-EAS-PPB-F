package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starbucks.ui.theme.StarbucksTheme

class VerifyOtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    VerifyOtpScreen(onClickVerify = {
                        navigateHome()
                    })
                }
            }
        }
    }

    private fun navigateHome(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyOtpScreen(onClickVerify: () -> Unit) {
    var otp by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Verify your phone number", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "We sent you a code to verify your phone number")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = otp,
            onValueChange = { otp = it },
            label = { Text(text = "OTP Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onClickVerify() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Verify")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "I didn't receive a code",
            modifier = Modifier.clickable { /* TODO: Resend code */ },
            color = MaterialTheme.colorScheme.primary
        )
    }
}
