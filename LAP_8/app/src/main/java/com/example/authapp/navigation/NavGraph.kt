package com.example.authapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authapp.ui.auth.AuthViewModel
import com.example.authapp.ui.auth.HomeScreen
import com.example.authapp.ui.auth.LoginScreen
import com.example.authapp.ui.auth.RegisterScreen

@Composable
fun SetupNavGraph(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController, authViewModel)
        }
        composable("register") {
            // Gọi màn hình thật ở đây
            RegisterScreen(navController, authViewModel)
        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}