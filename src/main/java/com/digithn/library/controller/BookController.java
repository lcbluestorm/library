package com.digithn.library.controller;


import com.digithn.library.config.annotation.UserToken;
import com.digithn.library.controller.param.BookParam;
import com.digithn.library.controller.param.UserLoginParam;
import com.digithn.library.entity.Book;
import com.digithn.library.entity.User;
import com.digithn.library.service.BookService;
import com.digithn.library.service.UserService;
import com.digithn.library.utils.PageResult;
import com.digithn.library.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(value = "v1", tags = "2. book相关接口")
@RequestMapping("/api/v1")
public class BookController {

    @Resource
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping("/books")
    @ApiOperation(value = "增加book接口", notes = "返回bookId")
    public Result<Long> addBook(@RequestBody @Valid BookParam bookParam, @ApiIgnore @UserToken User user) {
        logger.info("addBook api. userId: {}", user.getId());
        Result<Long> result = bookService.addBook(bookParam);
        logger.info("addBook api. result = {}", result);
        return result;
    }

    @GetMapping("/books")
    @ApiOperation(value = "查询book列表接口", notes = "返回book列表")
    public PageResult<Book> getBooks(@RequestParam(required = false) @ApiParam(value = "页码") Integer page,
                                     @RequestParam(required = false) @ApiParam(value = "每页条数") Integer count,
                                     @ApiIgnore @UserToken User user) {
        logger.info("getBooks api. userId: {}", user.getId());
        PageResult<Book> result = bookService.getBooks(page, count);
        return result;
    }

    @DeleteMapping("/books/{bookId}")
    @ApiOperation(value = "删除book接口", notes = "")
    public Result<Long> deleteBook(@ApiParam(value = "bookId") @PathVariable("bookId") Long bookId,
                                   @ApiIgnore @UserToken User user) {
        logger.info("deleteBook api. userId = {}", user.getId());
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/books/{bookId}")
    @ApiOperation(value = "查询book接口", notes = "返回book")
    public Result<Book> getBook(@ApiParam(value = "bookId") @PathVariable("bookId") Long bookId,
                                @ApiIgnore @UserToken User user) {
        logger.info("getBook api. userId = {}", user.getId());
        return bookService.getBook(bookId);
    }

    @PutMapping("/books/{bookId}")
    @ApiOperation(value = "更新book接口", notes = "返回book")
    public Result<Book> updateBook(@ApiParam(value = "bookId") @PathVariable("bookId") Long bookId,
                                   @RequestBody @Valid BookParam bookParam,
                                   @ApiIgnore @UserToken User user) {
        logger.info("updateBook api. userId = {}", user.getId());
        return bookService.updateBook(bookId, bookParam);
    }

}
