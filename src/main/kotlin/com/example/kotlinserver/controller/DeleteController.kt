package com.example.kotlinserver.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteController {

    @DeleteMapping("/delete")
    fun deleteMapping(
        @RequestParam name : String,
        @RequestParam age : Int
    ) : String{
        println(name)
        println(age)
        return name+" "+age
    }
}