package com.example.composetodolist.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetodolist.data.TodoItemViewModel
import com.example.composetodolist.data.model.TodoItem
import java.util.UUID

@Composable
fun EditScreen(
    viewModel: TodoItemViewModel,
    navController: NavController
) {

    val selectedItem by viewModel.selectedItem
    var titleText by remember { mutableStateOf(TextFieldValue(selectedItem?.title ?: "")) }
    var descriptionText by remember { mutableStateOf(TextFieldValue(selectedItem?.description ?: "")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = titleText,
                placeholder = { Text("제목을 입력하세요.") },
                onValueChange = { titleText = it },
            )

            IconButton(
                onClick = {
                    viewModel.addOrUpdateTodoItem(TodoItem(
                        id = selectedItem?.id ?: UUID.randomUUID(),
                        title = titleText.text,
                        description = descriptionText.text,
                        isComplete = selectedItem?.isComplete ?: false
                    ))
                    // MainScreen으로 네비게이션
                    navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "저장",
                    tint = Color.Green
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f),
            value = descriptionText,
            onValueChange = { descriptionText = it },
            placeholder = { Text(text = "내용을 입력하세요.") }
        )
        Spacer(modifier = Modifier.weight(0.3f))
    }
}