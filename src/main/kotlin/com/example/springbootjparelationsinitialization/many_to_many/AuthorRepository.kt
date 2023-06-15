package com.example.springbootjparelationsinitialization.many_to_many

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AuthorRepository : JpaRepository<Author, Long>