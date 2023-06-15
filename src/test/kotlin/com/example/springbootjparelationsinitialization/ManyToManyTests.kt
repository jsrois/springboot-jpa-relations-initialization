package com.example.springbootjparelationsinitialization

import com.example.springbootjparelationsinitialization.many_to_many.AuthorRepository
import com.example.springbootjparelationsinitialization.many_to_many.BookRepository
import com.example.springbootjparelationsinitialization.many_to_many.BookResponse
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ManyToManyTests {

    @Autowired
    private lateinit var api: TestRestTemplate

    @Test
    fun `returns the existing books with their authors`() {

        val response = api.getForEntity("/api/books", Array<BookResponse>::class.java)



    }
}
