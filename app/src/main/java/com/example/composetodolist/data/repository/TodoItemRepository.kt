package com.example.composetodolist.data.repository

import com.example.composetodolist.data.model.TodoItem
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface TodoItemRepository {

    fun getAllTodoItems(): Flow<List<TodoItem>>

    suspend fun insertOrUpdateTodoItem(todoItem: TodoItem)

    suspend fun getTodoItemById(id: UUID): TodoItem?

    suspend fun deleteItemById(id: UUID)

}