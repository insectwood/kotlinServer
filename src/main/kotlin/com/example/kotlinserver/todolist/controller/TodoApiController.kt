package com.example.kotlinserver.todolist.controller

import com.example.kotlinserver.todolist.model.TodoDto
import com.example.kotlinserver.todolist.service.TodoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    val todoService: TodoService
) {


    @GetMapping("")
    fun read(@RequestParam(required = false) index: Int):TodoDto?{
        return todoService.read(index)
    }

    @GetMapping("/all")
    fun readAll(): MutableList<TodoDto>{
        return todoService.readAll()
    }

    @PostMapping("")
    fun create(@Valid @RequestBody todoDtd: TodoDto): TodoDto? {
        return todoService.create(todoDtd)
    }

    @PutMapping("")
    fun update(@Valid @RequestBody todoDtd: TodoDto): TodoDto? {
        return todoService.update(todoDtd)
    }

    @DeleteMapping(path=["/{index}"])
    fun delete(@PathVariable(name = "index") index: Int): Boolean {

        //return type change : boolean -> ResponseEntity

        return todoService.delete(index)
    }
}