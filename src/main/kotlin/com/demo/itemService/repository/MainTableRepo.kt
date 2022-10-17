package com.demo.itemService.repository

import com.demo.itemService.entities.MainTable
import org.springframework.data.jpa.repository.JpaRepository


interface MainTableRepo: JpaRepository<MainTable, Int> {

}