package com.akos.library.server.interfaces;

import com.akos.library.common.entity.Book;

public interface EditBook {

    boolean save(Book book);
    boolean delete(Book book);
    boolean edit(Book book);
    boolean add(Book book);

}
