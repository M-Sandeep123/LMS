package com.incubyte.LMS.controller;

import com.incubyte.LMS.model.Book;
import com.incubyte.LMS.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(libraryService.addBook(book));
    }

    @PostMapping("/books/{id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.borrowBook(id));
    }

    @PostMapping("/books/{id}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(libraryService.returnBook(id));
    }

    @GetMapping("/books/available")
    public ResponseEntity<List<Book>> viewAvailableBooks() {
        return ResponseEntity.ok(libraryService.viewAvailableBooks());
    }
}

