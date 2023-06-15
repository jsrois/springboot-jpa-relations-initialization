package com.example.springbootjparelationsinitialization.many_to_many

data class BookResponse(val title: String,
                        val authors: List<AuthorResponse>,
                        val id: Long) {
    companion object {
        fun from(book: Book) = with(book) {
            BookResponse(title = title,
                    id = id,
                    authors = authors
                            .map(AuthorResponse.Companion::from)
                            .toList()
            )
        }
    }
}
