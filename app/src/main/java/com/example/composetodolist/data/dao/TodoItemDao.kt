package com.example.composetodolist.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composetodolist.data.entity.TodoItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoItemDao {

    @Query("SELECT * FROM todo_items ORDER BY createdDate DESC")
    fun getAllTodoItems(): Flow<List<TodoItemEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTodoItem(todoItemEntity: TodoItemEntity)
}