package com.mockito.exercise.sharing;

import com.mockito.exercise.sharing.assignment.Book;
import com.mockito.exercise.sharing.assignment.BookRepository;
import com.mockito.exercise.sharing.assignment.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


public class LibraryServiceTest {

    @Mock
    private BookRepository mockBookRepository;

    @InjectMocks
    private LibraryService mocklibraryService;

    @BeforeEach
 public void setUp(){

   MockitoAnnotations.openMocks(this);
    }


    @Test
    public void addBookTest(){
        Book book  = new Book(1, "Mockito in Action", "John Doe");

        mocklibraryService.addBook(book);

        verify(mockBookRepository, Mockito.times(1)).save(book);

    }

    @Test
    public void getBookTitleTest(){
        Book book  = new Book(1, "Mockito in Action", "John Doe");
        when(mocklibraryService.getBookByTitle("Mockito in Action")).thenReturn(book);

        Book foundBook = mocklibraryService.getBookByTitle("Mockito in Action");

        assertNotNull(foundBook);
        assertEquals("Mockito in Action", foundBook.getTitle());
        verify(mockBookRepository, times(1)).findByTitle("Mockito in Action");

    }

    @Test
    public void testListAllBooks(){
        Book book1 = new Book(1, "Mockito in Action", "John Doe");
        Book book2 = new Book(2, "Mockito Sharing", "Miggy Medina");
        List<Book> booksList = new ArrayList<>();
        booksList.add(book1);
        booksList.add(book2);

        when(mockBookRepository.findAll()).thenReturn(booksList);

        List<Book> allBooks = mocklibraryService.listAllBooks();

        assertEquals(2, allBooks.size());
        assertEquals("Mockito Sharing", allBooks.get(1).getTitle());
        verify(mockBookRepository, times(2)).findAll();





    }


}
