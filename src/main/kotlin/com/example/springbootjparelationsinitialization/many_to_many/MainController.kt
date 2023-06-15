package com.example.springbootjparelationsinitialization.many_to_many

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(private val authorRepository: AuthorRepository, private val bookRepository: BookRepository) {
    @GetMapping("/api/authors")
    fun allAuthors(): List<AuthorResponse> = authorRepository
            .findAll()
            .map(AuthorResponse::from)

    @GetMapping("/api/books")
    fun allBooks(): List<BookResponse> =
            bookRepository
                    .findAll()
                    .map(BookResponse::from)
}