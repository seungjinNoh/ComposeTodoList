package com.example.composetodolist.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetodolist.ui.screen.MainScreen

@Composable
fun TodoListApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}

sealed class Screen(val route: String) {
    object Main : Screen("main")
}