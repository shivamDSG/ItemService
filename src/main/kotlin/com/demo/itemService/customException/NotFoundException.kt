package com.demo.itemService.customException

class NotFoundException(message: String): Exception("$message") {

}