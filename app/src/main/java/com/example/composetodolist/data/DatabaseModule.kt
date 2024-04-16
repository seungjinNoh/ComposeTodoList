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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun provideTodoItemDao(database: TodoDatabase): TodoItemDao {
        return database.todoDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseProvider {

    @Binds
    abstract fun bindTodoItemRepository(
        todoItemRepositoryImpl: TodoItemRepositoryImpl
    ): TodoItemRepository
}