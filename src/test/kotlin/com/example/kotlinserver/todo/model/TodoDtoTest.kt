package com.example.kotlinserver.todo.model

import com.example.kotlinserver.todolist.model.TodoDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.validation.Validation

class TodoDtoTest {

    val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest(){

        val todoDto = TodoDto().apply{
            this.title="qweqwe"
            this.description=""
            this.schedule="2020-10-10 10:00:00"
        }

        val result = validator.validate(todoDto)
        Assertions.assertEquals(true, result.isEmpty())
    }
}