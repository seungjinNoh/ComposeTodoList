package com.example.composetodolist.data.repository

import com.example.composetodolist.data.dao.TodoItemDao
import com.example.composetodolist.data.mapperEntityToItem
import com.example.composetodolist.data.mapperItemToEntity
import com.example.composetodolist.data.model.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoItemRepositoryImpl @Inject constructor(
    private val todoItemDao: TodoItemDao
) : TodoItemRepository {

    override fun getAllTodoItems(): Flow<List<TodoItem>> = todoItemDao.getAllTodoItems().map {
        entities -> entities.map { entity -> mapperEntityToItem(entity) }
    }

    override suspend fun insertOrUpdateTodoItem(todoItem: TodoItem) {
        todoItemDao.insertOrUpdateTodoItem(mapperItemToEntity(todoItem = todoItem))
    }

    override suspend fun getTodoItemById(id: String): TodoItem? {
        val entity = todoItemDao.getTodoItemById(id)
        return entity?.let { mapperEntityToItem(it) }
    }

}
