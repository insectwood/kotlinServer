package com.example.kotlinserver.sample.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated
class DeleteController {

    @DeleteMapping("/delete")
    fun deleteMapping(
        @RequestParam name : String,

        @NotNull(message = "age is null")
        @Min(value = 20, message = "age must be higher than 20")
        @RequestParam age : Int
    ) : String{
        println(name)
        println(age)
        return name+" "+age
    }
}