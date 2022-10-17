package com.demo.itemService.customException

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val status: HttpStatus,
    val message: String
)