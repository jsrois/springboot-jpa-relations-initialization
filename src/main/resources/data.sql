insert into books(id, title)
values (1, 'The Communist Manifesto'),
       (2, 'Das Kapital');

insert into authors(id, name)
values (1, 'Karl Marx'),
       (2, 'Friedrich Engels');

insert into authors_books(book_id, author_id)
values (1,1),
       (1,2),
       (2,1);