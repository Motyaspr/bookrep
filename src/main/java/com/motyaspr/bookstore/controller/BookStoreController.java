package com.motyaspr.bookstore.controller;


import com.motyaspr.bookstore.dto.Book;
import com.motyaspr.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BookStoreController {

    private final BookService bookService;

    @GetMapping("/books/p")
    public List<Book> getAllBooksWithPagination(
            @RequestParam(name = "take", defaultValue = "-1") Integer take,
            @RequestParam(name = "skip", defaultValue = "0") Integer skip
    ) {
        return bookService.getAllBooks(take, skip);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping(value = "/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.saveNewBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBookInfo(@PathVariable("id") Integer bookId, @RequestBody Book book) {
        return bookService.updateBookById(bookId, book);
    }

    @DeleteMapping("/books/{id}")
    public Boolean deleteBookByID(@PathVariable("id") Integer bookId) {
        return bookService.deleteBookById(bookId);
    }

}
