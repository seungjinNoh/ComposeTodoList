package com.example.composetodolist.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetodolist.data.TodoItemViewModel
import com.example.composetodolist.data.model.TodoItem
import com.example.composetodolist.ui.Screen

@Composable
fun MainScreen(
    viewModel: TodoItemViewModel,
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.Edit.route) }) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(items = viewModel.todoItems, key = { item -> item.hashCode()}) { item ->
                TodoItemView(todoItem = item)
            }
        }
    }
}

@Composable
fun TodoItemView(todoItem: TodoItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = todoItem.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = todoItem.description)
        }
        Checkbox(
            checked = todoItem.isComplete,
//            onCheckedChange = { isChecked ->
//                onCheckedChange(isChecked)
//            }
            onCheckedChange = null
        )
    }
}