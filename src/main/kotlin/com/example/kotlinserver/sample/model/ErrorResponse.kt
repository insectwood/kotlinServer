package com.example.kotlinserver.sample.model

import java.time.LocalDateTime

data class ErrorResponse (
        var result_code:String?=null,
        var http_status:String?=null,
        var message:String?=null,
        var http_method:String?=null,
        var path:String?=null,
        var timestamp:LocalDateTime?=null,
        var errors:MutableList<Error>?= mutableListOf()
)

data class Error(
    var field:String?=null,
    var message:String?=null,
    var value:Any?=null
)
