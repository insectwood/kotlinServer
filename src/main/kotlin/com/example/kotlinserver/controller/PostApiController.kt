package com.example.kotlinserver.controller

import com.example.kotlinserver.model.UserInformation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post")
    fun postMapping(): String{
        return "post mapping"
    }

    @PostMapping("/post/object")
    fun objectMappingObject(@RequestBody userInfromation: UserInformation): UserInformation{
        println(userInfromation)
        return userInfromation
    }
}