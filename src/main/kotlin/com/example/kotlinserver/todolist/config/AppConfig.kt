package com.example.kotlinserver.todolist.config

import com.example.kotlinserver.todolist.db.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }
}