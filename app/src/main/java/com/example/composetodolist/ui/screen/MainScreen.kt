package com.example.composetodolist.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetodolist.data.TodoItemViewModel
import com.example.composetodolist.data.model.TodoItem
import com.example.composetodolist.ui.Screen
import java.util.UUID

@Composable
fun MainScreen(
    viewModel: TodoItemViewModel,
    navController: NavController
) {

    val todoItems by viewModel.todoItems.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("edit/new") }
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(items = todoItems, key = { item -> item.id }) { item ->
                TodoItemView(
                    todoItem = item,
                    onCheck = { isComplete ->
                              viewModel.addOrUpdateTodoItem(
                                  item.copy(isComplete = isComplete)
                              )
                    },
                    onClick = { navController.navigate("edit/${item.id}") },
                    onDelete = { viewModel.deleteItemById(UUID.fromString(item.id.toString())) }
                )
            }
        }
    }
}


@Composable
fun TodoItemView(todoItem: TodoItem, onCheck: (Boolean) -> Unit, onClick: () -> Unit, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick),
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
            onCheckedChange = { isCheck ->
                onCheck(isCheck)
            }
        )
        IconButton(onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}