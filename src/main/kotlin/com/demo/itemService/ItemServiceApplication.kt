package com.demo.itemService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class ItemServiceApplication

fun main(args: Array<String>) {
	runApplication<ItemServiceApplication>(*args)
}
