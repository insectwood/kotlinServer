package com.example.kotlinserver.todolist.db

import java.time.LocalDateTime

data class Todo(
        var index: Int?=null,
        var title: String?=null,
        var description: String?=null,
        var schedule: LocalDateTime?=null,
        var create_at: LocalDateTime?=null,
        var update_at: LocalDateTime?=null
)