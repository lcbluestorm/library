package com.digithn.library.controller.param;

import com.digithn.library.entity.Book;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BookParam {

    @ApiModelProperty("ISBN")
    @NotEmpty(message = "ISBN不能为空")
    private String isbn;

    @ApiModelProperty("书名")
    @NotEmpty(message = "书名不能为空")
    private String name;

    @ApiModelProperty("作者")
    @NotEmpty(message = "作者不能为空")
    private String author;

    @ApiModelProperty("类型")
    @NotEmpty(message = "书的类型不能为空")
    private String category;

    @ApiModelProperty("出版时间")
    @NotNull(message = "出版时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishTime;

    @ApiModelProperty("状态")
    private Byte status = 0;

    public String getISBN() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public Byte getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "BookParam{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}
