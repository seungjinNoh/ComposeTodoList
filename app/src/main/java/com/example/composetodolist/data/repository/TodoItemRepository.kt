package com.example.composetodolist.data.repository

import com.example.composetodolist.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoItemRepository {

    fun getAllTodoItems(): Flow<List<TodoItem>>

    suspend fun insertOrUpdateTodoItem(todoItem: TodoItem)
}