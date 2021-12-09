package com.example.kotlinserver.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    var result:Result?=null,
    var description:String?=null,

    @JsonProperty("user")
    var userInformation: MutableList<UserInformation>?=null
)

data class Result(
    var result_code:String?=null,
    var result_message:String?=null
)