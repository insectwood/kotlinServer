package com.example.kotlinserver.sample.controller

import com.example.kotlinserver.sample.model.Result
import com.example.kotlinserver.sample.model.UserInformation
import com.example.kotlinserver.sample.model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put")
    fun putMapping(): String{
        return "put mapping"
    }

    @PutMapping("/put/object")
    fun putMappingObject(@Valid @RequestBody userInformation: UserInformation, bindingResult: BindingResult): UserResponse{

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

    @PutMapping("/put/objectv")
    fun putMappingObjectValidation(@Valid @RequestBody userInformation: UserInformation, bindingResult: BindingResult): ResponseEntity<String> {
        if (bindingResult.hasErrors()) {
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.toString() + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }

        return ResponseEntity.badRequest().body("OK")
    }
}