package com.example.composetodolist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.composetodolist.data.entity.TodoItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoItemDao {

    fun getAllTodoItems(): Flow<List<TodoItemEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTodoItem(todoItemEntity: TodoItemEntity)
}