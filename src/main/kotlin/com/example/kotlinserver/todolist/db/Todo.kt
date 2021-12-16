package com.example.kotlinserver.todolist.db

import com.example.kotlinserver.todolist.model.TodoDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Todo(
        var index: Int?=null,
        var title: String?=null,
        var description: String?=null,
        var schedule: LocalDateTime?=null,
        var create_at: LocalDateTime?=null,
        var update_at: LocalDateTime?=null
)

fun Todo.convertTodo(todoDto: TodoDto): Todo{

        return Todo().apply {
                this.index = todoDto.index
                this.title = todoDto.title
                this.description = todoDto.description
                this.schedule = LocalDateTime.parse(todoDto.schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                this.create_at = todoDto.create_at
                this.update_at = todoDto.update_at
        }
}