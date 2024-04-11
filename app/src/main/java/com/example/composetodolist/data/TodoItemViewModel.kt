package com.example.composetodolist.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _selectedItem = mutableStateOf<TodoItem?>(null)
    val selectedItem: State<TodoItem?> = _selectedItem

    fun addOrUpdateTodoItem(todoItem: TodoItem) {
        val list = _todoItems.value.toMutableList()
        val index = list.indexOfFirst { it.id == todoItem.id }
        if (index != -1) {
            //기존 데이터가 있는 경우 update
            list[index] = todoItem
        } else {
            //기존 데이터가 없는 경우 추가
            list.add(todoItem)
        }
        _todoItems.value = list
    }

    fun updateTodoItemCompletion(itemId: UUID, isComplete: Boolean) {
        viewModelScope.launch {
            _todoItems.value = _todoItems.value.map { item ->
                if (item.id == itemId) item.copy(isComplete = isComplete) else item
            }
        }
    }

    fun setSelectedItem(todoItem: TodoItem) {
        _selectedItem.value = todoItem
    }

}