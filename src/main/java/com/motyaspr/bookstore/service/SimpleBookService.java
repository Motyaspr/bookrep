package com.motyaspr.bookstore.service;

import com.motyaspr.bookstore.dto.Book;
import com.motyaspr.bookstore.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@Primary
@Slf4j
@RequiredArgsConstructor
public class SimpleBookService implements BookService {

    private final BooksRepository booksRepository;

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.getAllBooks();
    }
    @Override
    public List<Book> getAllBooks(Integer take, Integer skip) {
        return booksRepository.getAllBooks(take, skip);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return booksRepository.getBookById(bookId);
    }

    @Override
    public Book saveNewBook(Book book) {
        return booksRepository.saveBook(book);
    }

    @Override
    public Book updateBookById(Integer bookId, Book book) {
        return booksRepository.updateBookById(bookId, book);
    }

    @Override
    public Boolean deleteBookById(Integer bookId) {
        return booksRepository.deleteBookById(bookId);
    }
}
