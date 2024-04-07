package com.example.composetodolist.data

import androidx.lifecycle.ViewModel
import com.example.composetodolist.data.model.TodoItem

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

}