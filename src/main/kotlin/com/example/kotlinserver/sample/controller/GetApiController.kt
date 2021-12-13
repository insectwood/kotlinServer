package com.example.kotlinserver.sample.controller

import com.example.kotlinserver.sample.model.UserInformation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/get/hello")
    fun hello(): String{
        return "hello kotlin"
    }

    @GetMapping("/get/path/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String{
        println("${name}, ${age}")
        return name+" "+age
    }

    @GetMapping("/get/query")
    fun queryParam(@RequestParam name: String, @RequestParam age: Int): String{
        println("${name}, ${age}")
        return name+" "+age
    }

    @GetMapping("/get/query/object")
    fun queryParamObject(userRequest: UserInformation): UserInformation{
        println(userRequest)
        return userRequest
    }

    @GetMapping("get/query/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }
}