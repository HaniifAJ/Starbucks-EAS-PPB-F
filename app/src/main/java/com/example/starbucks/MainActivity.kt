package com.example.starbucks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.starbucks.ui.theme.StarbucksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SignInScreen(
                        onSignInClicked = {},
                        onCreateAccountClicked = { navigateToCreateAccount() }
                    )
                }
            }
        }
    }

    private fun navigateToCreateAccount() {
        startActivity(Intent(this, TermsOfUseActivity::class.java))
    }
}

@Composable
fun SignInScreen(
    onSignInClicked: () -> Unit,
    onCreateAccountClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_starbucks_logo),
            contentDescription = "Starbucks Logo",
            modifier = Modifier.size(300.dp),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Starbucks",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.width(200.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Starbucks uses the highest quality arabica coffee as the base for its beloved drinks.",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.width(200.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSignInClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onCreateAccountClicked() },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Create New Account")
        }
    }
}
