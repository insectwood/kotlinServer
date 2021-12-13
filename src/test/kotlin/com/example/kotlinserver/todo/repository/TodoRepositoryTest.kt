package com.example.kotlinserver.todo.repository

import com.example.kotlinserver.todolist.config.AppConfig
import com.example.kotlinserver.todolist.db.Todo
import com.example.kotlinserver.todolist.repository.TodoRepositoryImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime


@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
class TodoRepositoryTest {

    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @Test
    fun saveTest(){
        val todo = Todo().apply{
            this.title = "test schedule"
            this.description = "test"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)

        Assertions.assertEquals(1, result.index)
        Assertions.assertNotNull(result.create_at)
        Assertions.assertNotNull(result.update_at)
        Assertions.assertEquals("test schedule", result.title)
        Assertions.assertEquals("test", result.description)
    }

    @Test
    fun saveAllTest(){
        val todoList = mutableListOf(
            Todo().apply{
                this.title = "test schedule"
                this.description = "test"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply{
                this.title = "test schedule"
                this.description = "test"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply{
                this.title = "test schedule"
                this.description = "test"
                this.schedule = LocalDateTime.now()
            }
        )

        val result = todoRepositoryImpl.saveAll(todoList)

        Assertions.assertEquals(true, result)
    }
}