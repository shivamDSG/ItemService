package com.demo.itemService.controller

import com.demo.itemService.entities.MainTable
import com.demo.itemService.service.MainTableService
import com.demo.itemService.service.MainTableServiceImpl
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Slf4j
@RestController
@RequestMapping
class ItemServiceController(private val service: MainTableService) {

    private val log: Logger = LoggerFactory.getLogger(MainTableServiceImpl::class.java)

    @PostMapping("addItem")
    @ResponseStatus(HttpStatus.CREATED)
    fun addNewItem(@RequestBody item: MainTable): ResponseEntity<String> = service.addNewItem(item)

    @GetMapping("getAllItem")
    fun getAllItemDetails(): Collection<MainTable> = service.getAllItemDetails()

    @PatchMapping("updateItem")
    fun updateItem(@RequestBody updatedItem: MainTable): ResponseEntity<String> {
        log.info("$updatedItem")
        return service.updateItem(updatedItem)
    }

    @DeleteMapping("deleteSingleItem/{id}")
    fun deleteSingleItem(@PathVariable id: Int): ResponseEntity<String> = service.deleteSingleItem(id)

    @DeleteMapping("deleteAllItem")
    fun deleteAllItem(): ResponseEntity<String> = service.deleteAllItem()
}