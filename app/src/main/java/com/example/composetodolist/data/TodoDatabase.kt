package com.example.composetodolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composetodolist.data.dao.TodoItemDao
import com.example.composetodolist.data.entity.TodoItemEntity

@Database(entities = [TodoItemEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoItemDao
}