package com.digithn.library.dao;

import com.digithn.library.common.PageInfo;
import com.digithn.library.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookMapper {

    int insertBook(Book book);

    Book selectBookById(@Param("id") Long id);

    List<Book> selectBooks(PageInfo pageInfo);

    int getTotalBooks();

    int deleteBookById(@Param("id") Long id);

    int updateBook(Book book);
}
