package com.example.kotlinserver.validator

import com.example.kotlinserver.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTimeValidator : ConstraintValidator<StringFormatDateTime, String> {

    private var pattern : String?=null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
        return try{
            true
        }catch(e:Exception){
            false
        }
    }
}