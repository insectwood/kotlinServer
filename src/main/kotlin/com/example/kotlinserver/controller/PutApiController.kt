package com.example.kotlinserver.controller

import com.example.kotlinserver.model.Result
import com.example.kotlinserver.model.UserInformation
import com.example.kotlinserver.model.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put")
    fun putMapping(): String{
        return "put mapping"
    }

    @PutMapping("/put/object")
    fun putMappingObject(@RequestBody userInformation: UserInformation): UserResponse{
        return UserResponse().apply {
            this.result = Result().apply {
                this.result_code = "OK"
                this.result_message = "Success"
            }
        }.apply {
            this.description = "description ~~~"
        }.apply {
            val userList = mutableListOf<UserInformation>()

            userList.add(userInformation)
            println(userList)
            userList.add(UserInformation().apply {
                this.name = "abc"
                this.age = 10
                this.email = "abc@gmail.com"
                this.address = "abc address"
                this.phone_number = "080-1234-1234"
            })
            userList.add(UserInformation().apply {
                this.name = "abc1122"
                this.age = 20
                this.email = "abc1122@gmail.com"
                this.address = "abc1122 address"
                this.phone_number = "080-1122-1122"
            })
            userList.add(UserInformation().apply {
                this.name = "abc987"
                this.age = 30
                this.email = "abc987@gmail.com"
                this.address = "abc987 address"
                this.phone_number = "080-9874-9874"
            })

            this.user = userList
        }
    }
}