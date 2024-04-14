package com.example.composetodolist.data

import android.content.Context
import androidx.room.Room
import com.example.composetodolist.data.dao.TodoItemDao
import com.example.composetodolist.data.repository.TodoItemRepository
import com.example.composetodolist.data.repository.TodoItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

    companion object {
        @Provides
        @Singleton
        fun provideDatabase(context: Context): TodoDatabase {
            return Room.databaseBuilder(
                context = context.applicationContext,
                TodoDatabase::class.java,
                "todo_database"
            ).build()
        }

        @Provides
        fun provideTodoItemDao(database: TodoDatabase): TodoItemDao {
            return database.todoDao()
        }
    }

    @Binds
    abstract fun bindTodoItemRepository(
        todoItemRepositoryImpl: TodoItemRepositoryImpl
    ): TodoItemRepository
}