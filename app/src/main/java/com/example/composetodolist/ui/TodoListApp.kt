package com.example.composetodolist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composetodolist.data.TodoItemViewModel
import com.example.composetodolist.ui.screen.EditScreen
import com.example.composetodolist.ui.screen.MainScreen

@Composable
fun TodoListApp() {
    val navController = rememberNavController()
    val viewModel: TodoItemViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.Main.route) {
            MainScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            route = "${Screen.Edit.route}/{${"itemId"}}",
            arguments = listOf(navArgument("itemId") { type = NavType.StringType})
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
            EditScreen(viewModel = viewModel, navController = navController, itemId = itemId)
        }

    }
}

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Edit : Screen("edit")
}