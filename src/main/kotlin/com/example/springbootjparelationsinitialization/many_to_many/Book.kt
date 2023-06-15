package com.example.springbootjparelationsinitialization.many_to_many

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import jakarta.persistence.*

@Entity
@Table(name = "books")
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator::class)
data class Book(
        var title: String,
        @ManyToMany
        @JoinTable(name = "authors_books",
                joinColumns = [JoinColumn(name = "author_id")],
                inverseJoinColumns = [JoinColumn(name = "book_id")])
        var authors: Set<Author>,
        @Id
        var id: Long
)