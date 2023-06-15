package com.example.springbootjparelationsinitialization

import com.example.springbootjparelationsinitialization.many_to_many.AuthorRepository
import com.example.springbootjparelationsinitialization.many_to_many.BookRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
class ManyToManyTests {

    @Autowired
    private lateinit var api: MockMvc

    @Autowired
    private lateinit var authorRepository: AuthorRepository
    @Autowired
    private lateinit var bookRepository: BookRepository

    @Test
    fun `returns the existing books with their authors`() {

        api.perform(get("/api/books"))
                .andExpect(status().isOk)

    }
}
