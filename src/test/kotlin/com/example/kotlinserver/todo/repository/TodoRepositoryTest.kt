package com.example.kotlinserver.todo.repository

import com.example.kotlinserver.todolist.domain.Todo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

//@ExtendWith(SpringExtension::class)
//@SpringBootTest(classes = [TodoRepositoryImpl::class, AppConfig::class])
class TodoRepositoryTest {
/*
    @Autowired
    lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @BeforeEach
    fun before(){
        todoRepositoryImpl.todoDataBase.init()
    }

    @Test
    fun saveTest(){
        val todo = Todo().apply{
            this.title = "test schedule"
            this.description = "test"
            this.schedule = LocalDateTime.now()
        }

        val result = todoRepositoryImpl.save(todo)

        Assertions.assertEquals(1, result?.index)
        Assertions.assertNotNull(result?.create_at)
        Assertions.assertNotNull(result?.update_at)
        Assertions.assertEquals("test schedule", result?.title)
        Assertions.assertEquals("test", result?.description)
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

    @Test
    fun findOneTest(){

        todoRepositoryImpl.todoDataBase.init()init

        val todoList = mutableListOf(
            Todo().apply{
                this.title = "test schedule1"
                this.description = "test1"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply{
                this.title = "test schedule2"
                this.description = "test2"
                this.schedule = LocalDateTime.now()
            },
            Todo().apply{
                this.title = "test schedule3"
                this.description = "test3"
                this.schedule = LocalDateTime.now()
            }
        )

        todoRepositoryImpl.saveAll(todoList)
        println(todoList)

        val result = todoRepositoryImpl.findOne(2)
        println(result)
        Assertions.assertEquals("test schedule2", result.title)
    }
 */
}