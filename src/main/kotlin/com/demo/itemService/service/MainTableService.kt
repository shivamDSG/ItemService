package com.demo.itemService.service

import com.demo.itemService.entities.MainTable
import org.springframework.http.ResponseEntity
import java.util.*

interface MainTableService {

    fun getAllItemDetails(): Collection<MainTable>

    fun addNewItem(item: MainTable): ResponseEntity<String>

    fun searchItem(id: Int): Optional<MainTable>

    fun updateItem(item: MainTable): ResponseEntity<String>

    fun deleteSingleItem(id: Int): ResponseEntity<String>

    fun deleteAllItem(): ResponseEntity<String>
}