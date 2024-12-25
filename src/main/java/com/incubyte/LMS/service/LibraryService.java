package com.incubyte.LMS.service;


import com.incubyte.LMS.model.Book;
import com.incubyte.LMS.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book borrowBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed");
        }
        book.setAvailable(false);
        return bookRepository.save(book);
    }

    public Book returnBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAvailable(true);
        return bookRepository.save(book);
    }

    public List<Book> viewAvailableBooks() {
        return bookRepository.findByAvailableTrue();
    }
}