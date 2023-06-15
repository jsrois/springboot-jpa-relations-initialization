package com.example.springbootjparelationsinitialization.many_to_many

import org.hibernate.annotations.NotFound
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.optionals.getOrElse

@RestController
class MainController(private val authorRepository: AuthorRepository, private val bookRepository: BookRepository) {
    @GetMapping("/api/authors")
    fun allAuthors(): List<AuthorResponse> = authorRepository
            .findAll()
            .map(AuthorResponse::from)

    @GetMapping("/api/authors/{authorId}/books")
    fun booksByAuthor(@PathVariable authorId: Long): List<Book> {
        return authorRepository.findById(authorId)
                .getOrElse { null }
                ?.let {
                    bookRepository.findBooksFromAuthorId(it.id)
                }
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Unable to find author with id $authorId")
    }

    @GetMapping("/api/books")
    fun allBooks(): List<BookResponse> =
            bookRepository
                    .findAll()
                    .map(BookResponse::from)
}