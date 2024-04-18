package com.example.composetodolist.data.model

import java.util.UUID

data class TodoItem(
    val id: UUID = UUID.randomUUID(), // 고유 식별자 추가
    val title: String,
    val description: String,
    var isComplete: Boolean,
    val createdDate: Long
)