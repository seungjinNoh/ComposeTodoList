package com.example.composetodolist.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "todo_items")
data class TodoItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    var isComplete: Boolean,
    val createdDate: Long
)
