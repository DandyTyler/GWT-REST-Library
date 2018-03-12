package com.akos.library.server;

import com.akos.library.common.entity.Author;
import com.akos.library.common.entity.Book;
import com.akos.library.common.entity.Genre;
import com.akos.library.common.entity.Publisher;
import com.akos.library.server.repository.AuthorRepository;
import com.akos.library.server.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDatabase {

    private Logger log = LoggerFactory.getLogger(InitDatabase.class);

    @Autowired
    public InitDatabase(BookRepository bookRepository, AuthorRepository authorRepository) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1947, Calendar.SEPTEMBER, 21);

        Author steev = new Author();
        steev.setFullName("Steven King");
        steev.setBirthday(new Date(calendar.getTime().getTime()));

        Set<Author> authors = new HashSet<>();
        authors.add(steev);

        Genre horrorGenre = new Genre("Horror");
        Publisher dc = new Publisher("Cool publisher");


        Book book1 = new Book();
        book1.setName("It");
        book1.setAuthors(authors);
        book1.setPublisher(dc);
        book1.setPublishYear(1995);
        book1.setGenre(horrorGenre);

        Book book2 = new Book();
        book2.setName("Shining");
        book2.setAuthors(authors);
        book2.setPublisher(dc);
        book2.setPublishYear(1986);
        book2.setGenre(horrorGenre);


        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);

        steev.setBooks(books);

        authorRepository.save(steev);
        bookRepository.save(book1);
        bookRepository.save(book2);

        // fetch all customers
        log.info("Books found with findAll():");
        log.info("-------------------------------");
        for (Book book : bookRepository.findAll()) {
            log.info(book.toString());
        }
        log.info("");

        log.info("Find book (IT) with findAllByName():");
        log.info("-------------------------------");
        for (Book book : bookRepository.findAllByName("It")) {
            log.info(book.toString());
        }
        log.info("");

    }
}
