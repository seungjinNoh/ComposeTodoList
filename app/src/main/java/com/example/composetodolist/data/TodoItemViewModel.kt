package com.example.composetodolist.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetodolist.data.model.TodoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class TodoItemViewModel : ViewModel() {

    private val _todoItems = MutableStateFlow<List<TodoItem>>(emptyList())
    val todoItems: StateFlow<List<TodoItem>> = _todoItems

    fun addTodoItem(todoItem: TodoItem) {
        viewModelScope.launch {
            _todoItems.value = _todoItems.value + todoItem
        }
    }

    fun updateTodoItemCompletion(itemId: UUID, isComplete: Boolean) {
        viewModelScope.launch {
            _todoItems.value = _todoItems.value.map { item ->
                if (item.id == itemId) item.copy(isComplete = isComplete) else item
            }
        }
    }

}