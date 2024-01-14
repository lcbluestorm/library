package com.digithn.library.service.impl;

import com.digithn.library.common.ErrorEnum;
import com.digithn.library.common.PageInfo;
import com.digithn.library.controller.param.BookParam;
import com.digithn.library.dao.BookMapper;
import com.digithn.library.entity.Book;
import com.digithn.library.service.BookService;
import com.digithn.library.utils.PageResult;
import com.digithn.library.utils.Result;
import com.digithn.library.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Result<Long> addBook(BookParam bookParam) {
        logger.info("addBook. bookParam: {}", bookParam);
        Book book = toBook(bookParam);
        bookMapper.insertBook(book);
        logger.info("addBook. book: {}", book);
        return ResultGenerator.getSuccessResult(book.getId());
    }

    @Override
    public PageResult<Book> getBooks(int page, int count) {
        logger.info("getBooks. page: {}, count: {}", page, count);
        if (count > 50) {
            count = 30;
        }
        PageInfo pageInfo = new PageInfo(page, count);
        List<Book> books = bookMapper.selectBooks(pageInfo);
        int total = bookMapper.getTotalBooks();
        PageResult<Book> pageResult = new PageResult(books, total, pageInfo.getCount(), pageInfo.getPage());
        return pageResult;
    }

    @Override
    public Result<Book> getBook(Long id) {
        logger.info("getBook. bookId: {}", id);
        Book book = bookMapper.selectBookById(id);
        logger.info("getBook. book: {}", book);
        if (book == null) {
            return ResultGenerator.getErrorResult(ErrorEnum.BookNotExistErr);
        }
        return ResultGenerator.getSuccessResult(book);
    }

    @Override
    public Result<Book> updateBook(Long bookId, BookParam bookParam) {
        logger.info("updateBook. bookId:{}, bookParam: {}", bookId, bookParam);
        Book existBook = bookMapper.selectBookById(bookId);
        if (existBook == null){
            return ResultGenerator.getErrorResult(ErrorEnum.BookNotExistErr);
        }
        Book book = toBook(bookParam);
        book.setId(bookId);
        System.out.println(book);
        bookMapper.updateBook(book);
        book.setCreateTime(existBook.getCreateTime());
        return ResultGenerator.getSuccessResult(book);
    }

    @Override
    public Result deleteBook(Long bookId) {
        logger.info("deleteBook. bookId: {}", bookId);
        Book existBook = bookMapper.selectBookById(bookId);
        if (existBook == null){
            return ResultGenerator.getErrorResult(ErrorEnum.BookNotExistErr);
        }

        bookMapper.deleteBookById(bookId);
        return ResultGenerator.getSuccessResult();
    }



    private Book toBook(BookParam bookParam) {
        Book book = new Book();
        book.setISBN(bookParam.getISBN());
        book.setName(bookParam.getName());
        book.setAuthor(bookParam.getAuthor());
        book.setCategory(bookParam.getCategory());
        book.setPublishTime(bookParam.getPublishTime());
        book.setStatus(bookParam.getStatus());
        return book;
    }
}
