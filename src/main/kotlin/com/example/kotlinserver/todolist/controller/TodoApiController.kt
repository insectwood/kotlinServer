package com.example.kotlinserver.todolist.controller

import com.example.kotlinserver.todolist.model.TodoDto
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoApiController {


    @GetMapping("")
    fun read(@RequestParam(required = false) index: Int?){

    }

    @PostMapping("")
    fun create(@Valid @RequestBody todoDtd: TodoDto){

    }

    @PutMapping("")
    fun update(@Valid @RequestBody todoDtd: TodoDto){

    }

    @DeleteMapping("")
    fun delete(@PathVariable(name = "index") index:Int){

    }
}