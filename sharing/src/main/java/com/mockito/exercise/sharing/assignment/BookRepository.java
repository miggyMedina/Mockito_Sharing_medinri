package com.mockito.exercise.sharing.assignment;

import java.util.List;

public interface BookRepository {

    void save(Book book);
    Book findByTitle(String title);
    List<Book> findAll();
}
