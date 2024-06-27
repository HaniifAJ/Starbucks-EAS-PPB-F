package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.starbucks.ui.theme.StarbucksTheme

class TermsOfUseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TermsOfUseScreen(
                        onClickAccept = {
                            navigateToCreateAccount()
                        }
                    )
                }
            }
        }
    }

    private fun navigateToCreateAccount() {
        startActivity(Intent(this, CreateAccountActivity::class.java))
    }
}

@Composable
fun TermsOfUseScreen(onClickAccept: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Terms of Use",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Last updated on 1/12/2021",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "1. Clause 1",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Viverrra condimentum eget purus in. Consectetuer eget id morbi amet amet, in. Ipsum viverra pretium tellus neque. Ullamcorper suspendisse aenean leo pharetra in sit semper et. Amet quam placerat sem.",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "2. Clause 2",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Viverrra condimentum eget purus in. Consectetuer eget id morbi amet amet, in. Ipsum viverra pretium tellus neque. Ullamcorper suspendisse aenean leo pharetra in sit semper et. Amet quam placerat sem.",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "3. Clause 3",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Viverrra condimentum eget purus in. Consectetuer eget id morbi amet amet, in. Ipsum viverra pretium tellus neque. Ullamcorper suspendisse aenean leo pharetra in sit semper et. Amet quam placerat sem.",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                onClickAccept()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Accept & Continue")
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}
