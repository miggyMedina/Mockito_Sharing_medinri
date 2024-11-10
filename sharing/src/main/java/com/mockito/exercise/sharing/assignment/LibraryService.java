package com.mockito.exercise.sharing.assignment;

import java.util.List;

public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}

