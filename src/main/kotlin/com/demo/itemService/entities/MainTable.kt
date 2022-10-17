package com.demo.itemService.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*

@Entity
data class MainTable(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var isActive: Boolean? = null,
    var createdDate: LocalDate? = null,
    var updatedDate: LocalDate? = null
)