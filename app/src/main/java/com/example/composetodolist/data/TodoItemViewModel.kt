package com.example.composetodolist.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetodolist.data.model.TodoItem
import com.example.composetodolist.data.repository.TodoItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TodoItemViewModel @Inject constructor(
    private val todoItemRepository: TodoItemRepository
) : ViewModel() {

    val todoItems: StateFlow<List<TodoItem>> = todoItemRepository.getAllTodoItems().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _editItem = MutableStateFlow<TodoItem?>(null)
    val editItem: StateFlow<TodoItem?> = _editItem.asStateFlow()

    fun addOrUpdateTodoItem(todoItem: TodoItem) = viewModelScope.launch {
        todoItemRepository.insertOrUpdateTodoItem(todoItem)
    }

    fun loadItemById(id: String) = viewModelScope.launch {
        if (id == "new") {
            _editItem.value = TodoItem(
                id = UUID.randomUUID(),
                title = "",
                description = "",
                isComplete = false,
                createdDate = System.currentTimeMillis()
            )
        } else {
            val uuid = UUID.fromString(id)
            val item = todoItemRepository.getTodoItemById(uuid)
            _editItem.value = item
        }
    }

    fun deleteItemById(id: UUID) = viewModelScope.launch {
        todoItemRepository.deleteItemById(id)
    }

}