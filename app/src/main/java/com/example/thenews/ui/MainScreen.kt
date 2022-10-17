package com.example.thenews.ui

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.thenews.navigation.BottomNavGraph
import com.example.thenews.navigation.BottomNavBar
import com.example.thenews.ui.auth.AuthViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val bottomBarNavController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            BottomNavBar(bottomBarNavController)
        }
    ) {
        BottomNavGraph(bottomBarNavController)
    }
}