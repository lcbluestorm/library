package com.digithn.library.common;

import java.util.Map;

public class PageInfo {

    //当前页码
    private int page;

    //每页条数
    private int count;
    private int start;

    public PageInfo(int page, int count) {

        //分页参数
        this.page = page;
        this.count = count;
        this.start = (page -1 ) * count;
    }

    public int getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", count=" + count +
                ", start=" + start +
                '}';
    }
}
