package com.example.springbootjparelationsinitialization.many_to_many

data class AuthorResponse(val name: String,
                          val id: Long) {
    companion object {
        fun from(author: Author) =
            with(author) {
                AuthorResponse(name = name, id = id)
            }
    }
}
