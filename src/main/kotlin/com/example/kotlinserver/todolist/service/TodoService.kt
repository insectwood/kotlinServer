package com.example.kotlinserver.todolist.service

import com.example.kotlinserver.todolist.domain.Todo
import com.example.kotlinserver.todolist.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepository: TodoRepository
) {
    //CURD
    fun findById(id: Long) = todoRepository.findById(id)
    fun findAll(): MutableList<Todo> = todoRepository.findAll()
    fun save(todo: Todo) = todoRepository.save(todo)
    fun delete(id: Long) = todoRepository.deleteById(id)
}