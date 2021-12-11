package com.example.kotlinserver.annotation

import com.example.kotlinserver.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class])
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class StringFormatDateTime (
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "time type has not validated",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)