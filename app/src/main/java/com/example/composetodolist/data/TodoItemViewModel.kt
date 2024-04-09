package com.example.composetodolist.data

import androidx.lifecycle.ViewModel
import com.example.composetodolist.data.model.TodoItem
import java.util.UUID

class TodoItemViewModel : ViewModel() {

    private val _todoItems = mutableListOf<TodoItem>()
    val todoItems: List<TodoItem> get() = _todoItems

    fun addTodoItem(todoItem: TodoItem) {
        _todoItems.add(
            TodoItem(
                title = todoItem.title,
                description = todoItem.description,
                isComplete = todoItem.isComplete
            )
        )
    }

    fun updateTodoItemCompletion(itemId: UUID, isComplete: Boolean) {
        _todoItems.find { it.id == itemId }?.let {
            val updatedItem = it.copy(isComplete = isComplete)
            _todoItems[_todoItems.indexOf(it)] = updatedItem
        }
    }

}