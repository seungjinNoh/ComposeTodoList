package com.example.composetodolist.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composetodolist.data.model.TodoItem

@Composable
fun MainScreen() {

    //todo viewModel 구조로 변경
    val todoItems = remember {
        mutableStateListOf<TodoItem>().apply {
            add(TodoItem("Buy groceries", "Milk, Eggs, Flour", isComplete = true))
            add(TodoItem("Read books", "Finish reading 'Compose for Android'", isComplete = false))
            add(TodoItem("Plan holiday", "Book flights and accommodation", isComplete = false))
        }
    }

    LazyColumn {
        itemsIndexed(todoItems) { index, item ->
            TodoItemView(todoItem = item) { completed ->
                val updatedItem = item.copy(isComplete = completed)
                todoItems[index] = updatedItem
            }
            Divider()
        }
    }

}

@Composable
fun TodoItemView(todoItem: TodoItem, onCheckedChange: (Boolean) -> Unit) {
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
            onCheckedChange = { isChecked ->
                onCheckedChange(isChecked)
            }
        )
    }
}