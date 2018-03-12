package com.akos.library.server.interfaces;

import com.akos.library.common.entity.Book;

public interface ShowBook {

    void showBook(Book book);
    void downloadBook(Book book);
}
