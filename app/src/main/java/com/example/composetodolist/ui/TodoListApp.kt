package com.example.composetodolist.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetodolist.ui.screen.EditScreen
import com.example.composetodolist.ui.screen.MainScreen

@Composable
fun TodoListApp() {
    val navController = rememberNavController()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.Edit.route) }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Main.route) {
                MainScreen()
            }
            composable(Screen.Edit.route) {
                EditScreen()
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Edit : Screen("edit")
}