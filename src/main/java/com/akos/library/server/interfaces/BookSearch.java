package com.akos.library.server.interfaces;

import com.akos.library.common.entity.Author;
import com.akos.library.common.entity.Book;
import com.akos.library.common.entity.Genre;

import java.util.List;

public interface BookSearch {

    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);

}
