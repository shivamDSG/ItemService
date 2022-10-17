package com.demo.itemService.service

import com.demo.itemService.entities.MainTable
import org.springframework.http.ResponseEntity

interface MainTableService {

    fun getAllItemDetails(): Collection<MainTable>

    fun addNewItem(item: MainTable): ResponseEntity<String>

    fun updateItem(item: MainTable): ResponseEntity<String>

    fun deleteSingleItem(id: Int): ResponseEntity<String>

    fun deleteAllItem(): ResponseEntity<String>
}