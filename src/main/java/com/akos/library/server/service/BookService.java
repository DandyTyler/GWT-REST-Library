package com.akos.library.server.service;

import com.akos.library.common.entity.Book;
import com.akos.library.common.entity.Person;
import com.akos.library.server.repository.BookRepository;
import com.akos.library.server.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository repository) {
        bookRepository = repository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByName(String bookName) {
        return bookRepository.findByName(bookName);
    }

    public Book getById(Long id) {
        return bookRepository.findOne(id);
    }

}
