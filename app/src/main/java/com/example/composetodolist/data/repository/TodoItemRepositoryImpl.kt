package com.example.composetodolist.data.repository

import com.example.composetodolist.data.dao.TodoItemDao
import com.example.composetodolist.data.model.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoItemRepositoryImpl @Inject constructor(
    private val todoItemDao: TodoItemDao
) : TodoItemRepository {

    override fun getAllTodoItems(): Flow<List<TodoItem>> {
        return flow {

        }
    }
}