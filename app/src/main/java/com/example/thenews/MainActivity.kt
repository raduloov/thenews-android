package com.example.thenews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.rememberScaffoldState
import com.example.thenews.navigation.RootNavGraph
import com.example.thenews.ui.theme.TheNewsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var application: BaseApplication

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()

            TheNewsTheme(
                darkTheme = application.isDark.value,
                scaffoldState = scaffoldState
            ) {
                RootNavGraph(
                    darkTheme = application.isDark.value
                )
            }
        }
    }
}