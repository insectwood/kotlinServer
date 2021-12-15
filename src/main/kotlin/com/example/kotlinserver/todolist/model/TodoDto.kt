package com.example.kotlinserver.todolist.model

import com.example.kotlinserver.sample.annotation.StringFormatDateTime
import java.time.LocalDateTime
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
