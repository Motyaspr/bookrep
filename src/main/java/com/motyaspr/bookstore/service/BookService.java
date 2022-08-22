package com.motyaspr.bookstore.service;

import com.motyaspr.bookstore.dto.Book;

import java.util.List;
import java.util.UUID;

/**
 * Service for work with books.
 */
public interface BookService {

    List<Book> getAllBooks();
    /**
     * Get books.
     *
     * @param take pagination parameter take
     * @param skip pagination parameter skip
     * @return list of books
     */
    List<Book> getAllBooks(Integer take, Integer skip);

    /**
     * Get Book by ID.
     *
     * @param bookId Book UUID
     * @return book, if book with given id stores in db
     */
    Book getBookById(Integer bookId);

    /**
     * Save book.
     *
     * @param book book to save
     * @return saved book
     */
    Book saveNewBook(Book book);

    /**
     * Update book metadata.
     *
     * @param bookId Book UUID
     * @param book   Book metadata to update
     * @return updated book metadata
     */
    Book updateBookById(Integer bookId, Book book);

    /**
     * Delete book by ID.
     *
     * @param bookId Book UUID
     * @return true if book deleted or false if book not found or exception occurred
     */
    Boolean deleteBookById(Integer bookId);
}
