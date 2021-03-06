package com.example.kotlinserver.sample.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler

//@RestControllerAdvice
class GlobalExceptionAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String{
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}