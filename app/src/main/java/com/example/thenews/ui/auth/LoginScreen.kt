package com.example.thenews.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.thenews.data.authRepository.Resource
import com.example.thenews.navigation.AuthScreen
import com.example.thenews.navigation.Graph
import com.example.thenews.ui.auth.util.getAuthErrorMessage
import com.example.thenews.ui.components.CircularIndeterminateProgressBar
import com.example.thenews.ui.components.LogoGradient
import com.example.thenews.ui.theme.Grey500

@Composable
fun LoginScreen(
    navController: NavController,
    isDark: Boolean
) {
    val viewModel: AuthViewModel = hiltViewModel()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var authError by remember { mutableStateOf("") }

    val authResource = viewModel.loginFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        LogoGradient(isDark = isDark)

        Text(
            text = "LOGIN",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            style = MaterialTheme.typography.h2
        )

        Text(
            text = authError,
            modifier = Modifier.padding(top = 10.dp),
            color = Color.Red,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Column(
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = "Email")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { viewModel.loginUser(email, password) }
                    )
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    viewModel.loginUser(email, password)
                }
            ) {
                Text(text = "Log in", style = MaterialTheme.typography.button)
            }


            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Don't have an account?",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center,
                    color = Grey500
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate(AuthScreen.SignUp.route) {
                                popUpTo(AuthScreen.Login.route) { inclusive = true }
                            }
                        },
                    text = "Sign up",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }

    authResource.value?.let {
        when (it) {
            is Resource.Failure -> {
                authError = getAuthErrorMessage(it.exception.message.toString())
            }
            is Resource.Loading -> {
                Box {
                    CircularIndeterminateProgressBar(verticalBias = 0.4f)
                }
            }
            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(Graph.LOGGED_IN) {
                        popUpTo(Graph.AUTH) { inclusive = true }
                    }
                }
            }
        }
    }
}