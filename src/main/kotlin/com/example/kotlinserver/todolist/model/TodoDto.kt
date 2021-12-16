package com.example.kotlinserver.todolist.model

import com.example.kotlinserver.sample.annotation.StringFormatDateTime
import com.example.kotlinserver.todolist.db.Todo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.NotBlank

data class TodoDto (
        var index:Int?=null,

        @field:NotBlank
        var title:String?=null,

        var description:String?=null,

        @field:NotBlank
        @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "not matched pattern")
        var schedule:String?=null,

        var create_at:LocalDateTime?=null,

        var update_at:LocalDateTime?=null
)

fun TodoDto.convertTodoDto(todo: Todo): TodoDto {
        return TodoDto().apply {
                this.index = todo.index
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                this.create_at = todo.create_at
                this.update_at = todo.update_at
        }
}
