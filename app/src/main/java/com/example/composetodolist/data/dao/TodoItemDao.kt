package com.example.composetodolist.data.dao

import androidx.room.Dao
import com.example.composetodolist.data.entity.TodoItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoItemDao {

    fun getAllTodoItems(): Flow<List<TodoItemEntity>>

}