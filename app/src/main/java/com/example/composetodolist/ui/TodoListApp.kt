package com.example.composetodolist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetodolist.data.TodoItemViewModel
import com.example.composetodolist.ui.screen.EditScreen
import com.example.composetodolist.ui.screen.MainScreen

@Composable
fun TodoListApp() {
    val navController = rememberNavController()
    val viewModel: TodoItemViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.Main.route) {
            MainScreen(viewModel = viewModel, navController = navController)
        }
        composable(Screen.Edit.route) {
            EditScreen(viewModel = viewModel, navController = navController)
        }
    }
}

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Edit : Screen("edit")
}