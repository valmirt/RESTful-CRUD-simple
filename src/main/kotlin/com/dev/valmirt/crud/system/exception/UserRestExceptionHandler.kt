package com.dev.valmirt.crud.system.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserRestExceptionHandler {

    @ExceptionHandler
    fun handleException (e: UserNotFoundException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(HttpStatus.NOT_FOUND.value(),
                e.message,
                System.currentTimeMillis())

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleException(e: Exception): ResponseEntity<ErrorResponse>{
        val error = ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.message,
                System.currentTimeMillis())

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}