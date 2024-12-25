package com.incubyte.LMS;

import com.incubyte.LMS.model.Book;
import com.incubyte.LMS.repository.BookRepository;
import com.incubyte.LMS.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryServiceTest {
    private LibraryService libraryService;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        libraryService = new LibraryService(bookRepository);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = libraryService.addBook(book);
        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
    }

    @Test
    void testBorrowBook() {
        Book book = new Book();
        book.setId(1L);
        book.setAvailable(true);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Book borrowedBook = libraryService.borrowBook(1L);
        assertFalse(borrowedBook.isAvailable());
    }
}
