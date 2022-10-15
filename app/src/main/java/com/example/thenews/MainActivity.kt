package com.example.thenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thenews.ui.components.auth.AuthViewModel
import com.example.thenews.ui.theme.TheNewsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel(modelClass = AuthViewModel::class.java)
            TheNewsTheme {
                Navigation(loginViewModel = loginViewModel)
            }
        }
    }
}