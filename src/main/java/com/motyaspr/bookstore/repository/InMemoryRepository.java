package com.motyaspr.bookstore.repository;

import com.motyaspr.bookstore.dto.Book;
import com.motyaspr.bookstore.exception.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@ConditionalOnProperty(value = "db.type", havingValue = "in-memory")
@Primary
@Slf4j
public class InMemoryRepository implements BooksRepository {

    private final Map<Integer, Book> books = new ConcurrentHashMap<>();

    @Override
    public List<Book> getAllBooks(Integer take, Integer skip) {
        if (skip + take >= books.size()) {
            log.info("can't take books");
            return new ArrayList<>();
        }

        return new ArrayList<>(books.values()).subList(skip, skip + take);
    }

    @Override
    public Book saveBook(Book book) {
        Random random = new Random();
        var bookInDb = books.values().stream().filter(v -> v.getIsbn().equals(book.getIsbn()))
                .findFirst();
        if (bookInDb.isPresent()) {
            log.info("Book with given isbn {} already exists in db", book.getIsbn());
            return bookInDb.get();
        }
        if (book.getUuid() == null) {
            book.setUuid(random.nextInt());
        }
        books.put(book.getUuid(), book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBookById(Integer id) {
        return Optional.ofNullable(books.get(id))
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with id %s not found", id)));
    }

    @Override
    public Boolean deleteBookById(Integer id) {
        var deletedBook = books.remove(id);
        if (Objects.isNull(deletedBook)) {
            log.warn("There is no book with given id {}. Nothing to delete", id);
            return false;
        }
        return true;
    }

    @Override
    public Book updateBookById(Integer id, Book book) {
        Optional.ofNullable(books.get(id))
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with id %s not found", id)));
        book.setUuid(id);
        books.put(id, book);
        return book;
    }
}
