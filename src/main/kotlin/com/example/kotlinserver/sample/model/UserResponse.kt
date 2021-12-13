package com.example.kotlinserver.sample.model

data class UserResponse(
    var result:Result?=null,
    var description:String?=null,
    var user: MutableList<UserInformation>?=null
)

data class Result(
    var result_code:String?=null,
    var result_message:String?=null
)