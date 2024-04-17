package com.example.composetodolist.data

import com.example.composetodolist.data.entity.TodoItemEntity
import com.example.composetodolist.data.model.TodoItem

fun mapperEntityToItem(todoItemEntity: TodoItemEntity): TodoItem {
    return TodoItem(
        id = todoItemEntity.id,
        title = todoItemEntity.title,
        description = todoItemEntity.description,
        isComplete = todoItemEntity.isComplete
    )
}

fun mapperItemToEntity(todoItem: TodoItem): TodoItemEntity {
    return TodoItemEntity(
        id = todoItem.id,
        title = todoItem.title,
        description = todoItem.description,
        isComplete = todoItem.isComplete,
        createdDate = todoItem.createdDate
    )
}