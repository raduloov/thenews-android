package com.example.thenews.ui.components.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thenews.ui.theme.TheNewsTheme

@Composable
fun SignInScreen(
    viewModel: AuthViewModel? = null,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit
) {
    val authUiState = viewModel?.authUiState
    val isError = authUiState?.loginError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary
        )

        if (isError) {
            Text(
                text = authUiState?.loginError ?: "An unknown error occurred.",
                color = Color.Red
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = authUiState?.username ?: "",
            onValueChange = { viewModel?.onUsernameChange(it) },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text(text = "Email") },
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = authUiState?.password ?: "",
            onValueChange = { viewModel?.onPasswordChange(it) },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { viewModel?.loginUser(context) }) {
            Text(text = "Sign in")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account?")
            TextButton(onClick = { onNavigateToSignUpScreen.invoke() }) {
                Text(text = "Sign up")
            }
        }

        if (authUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = viewModel?.hasUser) {
            if (viewModel?.hasUser == true) {
                onNavigateToHomeScreen.invoke()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    TheNewsTheme {
        SignInScreen(onNavigateToHomeScreen = { /*TODO*/ }) {
            
        }
    }
}