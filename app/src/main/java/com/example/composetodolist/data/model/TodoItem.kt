package com.example.composetodolist.data.model

data class TodoItem(
    val title: String,
    val description: String,
    var isComplete: Boolean
)
