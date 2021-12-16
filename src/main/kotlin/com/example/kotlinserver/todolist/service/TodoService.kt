package com.example.kotlinserver.todolist.service

import com.example.kotlinserver.todolist.db.Todo
import com.example.kotlinserver.todolist.db.convertTodo
import com.example.kotlinserver.todolist.model.TodoDto
import com.example.kotlinserver.todolist.model.convertTodoDto
import com.example.kotlinserver.todolist.repository.TodoRepositoryImpl
import org.springframework.stereotype.Service

@Service
class TodoService {

    val todoRepositoryImpl = TodoRepositoryImpl()

    //CURD

    fun create(todoDto: TodoDto): TodoDto?{
        return todoDto.let {
            Todo().convertTodo(it)
        }.let{
            todoRepositoryImpl.save(it)
        }?.let {
            TodoDto().convertTodoDto(it)
        }
    }

    fun read(index:Int): TodoDto? {
        return todoRepositoryImpl.findOne(index)?.let{
            TodoDto().convertTodoDto(it)
        }
    }

    fun readAll(): MutableList<TodoDto> {
        return todoRepositoryImpl.findAll().map{
            TodoDto().convertTodoDto(it)
        }.toMutableList()
    }

    fun update(todoDto: TodoDto): TodoDto? {
        return todoDto.let {
            Todo().convertTodo(it)
        }.let{
            todoRepositoryImpl.save(it)
        }?.let{
            TodoDto().convertTodoDto(it)
        }
    }

    fun delete(index: Int): Boolean {
        return todoRepositoryImpl.delete(index)
    }
}