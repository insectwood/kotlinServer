package com.example.kotlinserver.todolist.controller

import com.example.kotlinserver.todolist.domain.Todo
import com.example.kotlinserver.todolist.service.TodoService
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    val todoService: TodoService
) {

    @GetMapping("")
    fun read(@RequestParam(required = false) id: Long): Optional<Todo> {
        return todoService.findById(id)
    }

    @GetMapping("/all")
    fun readAll(): MutableList<Todo>{
        return todoService.findAll()
    }

    @PostMapping("")
    fun create(@Valid @RequestBody todo: Todo): Todo? {
        return todoService.save(todo)
    }

    @PutMapping("")
    fun update(@Valid @RequestBody todo: Todo): Todo? {
        return todoService.save(todo)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(name = "id") id: Long) {
        return todoService.delete(id)
    }
}