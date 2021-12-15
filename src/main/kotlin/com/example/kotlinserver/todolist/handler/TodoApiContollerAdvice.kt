package com.example.kotlinserver.todolist.handler

import com.example.kotlinserver.todolist.controller.TodoApiController
import com.example.kotlinserver.todolist.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackageClasses = [TodoApiController::class])
class TodoApiContollerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {

        val errors = mutableListOf<com.example.kotlinserver.todolist.model.Error>()

        e.bindingResult.allErrors.forEach{
            errorObject ->
            val error = com.example.kotlinserver.todolist.model.Error().apply{
                this.field = (errorObject as FieldError).field
                this.message = errorObject.defaultMessage
                this.value = errorObject.rejectedValue
            }
            errors.add(error)
        }

        val errorResponse = ErrorResponse().apply {
            this.result_code = "FAIL"
            this.http_status = HttpStatus.BAD_REQUEST.value().toString()
            this.http_method = request.method
            this.message = "message"
            this.path = request.requestURI
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.badRequest().body(errorResponse)
    }
}