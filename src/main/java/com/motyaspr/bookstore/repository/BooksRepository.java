package com.motyaspr.bookstore.repository;

import com.motyaspr.bookstore.dto.Book;

import java.util.List;
import java.util.UUID;

/**
 * Repository to work with book metadata.
 */
public interface BooksRepository {

    /**
     * Save book.
     *
     * @param book book to save
     * @return saved book
     */
    Book saveBook(Book book);

    /**
     * Get all books from db.
     *
     * @return list of all books
     */
    List<Book> getAllBooks();

    List<Book> getAllBooks(Integer take, Integer skip);

    /**
     * Get Book by ID.
     *
     * @param id Book UUID
     * @return book, if book with given id stores in db
     */
    Book getBookById(Integer id);


    /**
     * Delete book by ID.
     *
     * @param id Book UUID
     * @return true if book deleted or false if book not found or exception occurred
     */
    Boolean deleteBookById(Integer id);

    /**
     * Update book metadata.
     *
     * @param id   Book UUID
     * @param book Book metadata to update
     * @return updated book metadata
     */
    Book updateBookById(Integer id, Book book);
}
