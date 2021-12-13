package com.example.kotlinserver.sample.controller

import com.example.kotlinserver.sample.model.UserInformation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post")
    fun postMapping(): String{
        return "post mapping"
    }

    @PostMapping("/post/object")
    fun objectMappingObject(@Valid @RequestBody userInfromation: UserInformation): UserInformation{
        println(userInfromation)
        return userInfromation
    }
}