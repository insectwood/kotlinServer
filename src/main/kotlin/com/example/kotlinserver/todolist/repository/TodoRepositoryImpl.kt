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

    override fun save(todo: Todo): Todo? {
//        val index = todoDataBase.index + 1
//        todoDataBase.todoList.add(todo)

        return todo.index?.let{
            index ->
            return findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.update_at = todo.update_at
            }
        }?: kotlin.run {
            return todo.apply {
                this.index = ++todoDataBase.index
                this.create_at = LocalDateTime.now()
                this.update_at = LocalDateTime.now()
            }.run{
                todoDataBase.todoList.add(todo)
                this
            }
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
        val todo = findOne(index)

        return todo?.let{
            todoDataBase.todoList.remove(it)
            true
        }?: kotlin.run{
            false
        }
    }

    override fun findOne(index: Int): Todo {
        return todoDataBase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }

}