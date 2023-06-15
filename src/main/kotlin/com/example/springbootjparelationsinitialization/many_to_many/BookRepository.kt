package com.example.springbootjparelationsinitialization.many_to_many

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    @Query("select b from Book b join b.authors a where a.id = :authorId")
    fun findBooksFromAuthorId(@Param("authorId") authorId: Long): List<Book>
}