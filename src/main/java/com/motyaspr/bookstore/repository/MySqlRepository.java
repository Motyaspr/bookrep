package com.motyaspr.bookstore.repository;

import com.motyaspr.bookstore.dto.Book;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//TODO implement for MySQL task
@Repository
@ConditionalOnProperty(value = "db.type", havingValue = "mysql")
public class MySqlRepository implements BooksRepository {
    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public List<Book> getAllBooks(Integer take, Integer skip) {
        return null;
    }

    @Override
    public Book getBookById(Integer id) {
        return null;
    }

    @Override
    public Boolean deleteBookById(Integer id) {
        return null;
    }

    @Override
    public Book updateBookById(Integer id, Book book) {
        return null;
    }
}
