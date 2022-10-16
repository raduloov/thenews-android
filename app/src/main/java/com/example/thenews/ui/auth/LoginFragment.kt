package com.example.thenews.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.thenews.BaseApplication
import com.example.thenews.ui.theme.TheNewsTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.ui.Modifier
import androidx.navigation.findNavController
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val scaffoldState = rememberScaffoldState()

                TheNewsTheme(
                    darkTheme = application.isDark.value,
                    scaffoldState = scaffoldState
                ) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        snackbarHost = { scaffoldState.snackbarHostState }
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            LoginScreen(
                                viewModel = viewModel,
                                navController = findNavController(),
                                isDark = application.isDark.value
                            )
                        }
                    }
                }
            }
        }
    }

}