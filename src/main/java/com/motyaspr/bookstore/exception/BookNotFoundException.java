package com.motyaspr.bookstore.exception;

/**
 * Business exception in case of book not found.
 */
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
