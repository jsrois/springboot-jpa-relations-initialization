package com.example.springbootjparelationsinitialization.many_to_many

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*

@Entity
@Table(name = "authors")
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
data class Author(
        var name: String,
        @Id
        var id: Long
)