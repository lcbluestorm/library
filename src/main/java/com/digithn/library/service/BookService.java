package com.digithn.library.service;

import com.digithn.library.common.PageInfo;
import com.digithn.library.controller.param.BookParam;
import com.digithn.library.entity.Book;
import com.digithn.library.utils.PageResult;
import com.digithn.library.utils.Result;

public interface BookService {

    Result<Long> addBook(BookParam bookParam);

    PageResult<Book> getBooks(int page, int count);

    Result deleteBook(Long id);

    Result<Book> getBook(Long id);

    Result<Book> updateBook(Long bookId, BookParam bookParam);

}
