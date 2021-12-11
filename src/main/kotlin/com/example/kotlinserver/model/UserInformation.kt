package com.example.kotlinserver.model

import com.example.kotlinserver.annotation.StringFormatDateTime
import javax.validation.constraints.*

data class UserInformation(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,
    var address:String?=null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phone_number:String?=null,

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "not matched pattern")
    var createdAt:String?=null
)