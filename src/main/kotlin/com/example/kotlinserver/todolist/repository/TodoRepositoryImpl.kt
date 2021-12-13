package com.example.kotlinserver.todolist.repository

import com.example.kotlinserver.todolist.db.Todo
import com.example.kotlinserver.todolist.db.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase

    override fun save(todo: Todo): Todo {
//        val index = todoDataBase.index + 1
//        todoDataBase.todoList.add(todo)

        return todo.apply {
            this.index = todoDataBase.index+1
            this.create_at = LocalDateTime.now()
            this.update_at = LocalDateTime.now()
        }.run{
            todoDataBase.todoList.add(todo)
            this
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try{
            todoList.forEach{
                save(it)
            }
            true
        }catch (e: Exception){
            false
        }
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }

}