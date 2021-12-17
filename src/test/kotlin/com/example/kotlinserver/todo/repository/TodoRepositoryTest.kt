package com.example.kotlinserver.todo.repository

import com.example.kotlinserver.todolist.repository.TodoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepository: TodoRepository

    @Test
    fun findByIdTest(){
        val result = todoRepository.findById(2)
        println(result)
        Assertions.assertEquals("title 1 ", result.get().title)
    }
}