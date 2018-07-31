package com.simple.multiDataSource.utils;

import java.util.Collections;
import java.util.List;

/**
 * 分页数据消息体
 */
public class PageResponse<T> {

    /**
     * 当前页数据列表
     */
    private List<T> entries;

    /**
     * 总数
     */
    private int total;

    public PageResponse() {
        this(Collections.<T>emptyList(), 0);
    }

    public PageResponse(List<T> entries, int total) {
        this.entries = entries;
        this.total = total;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static final PageResponse EMPTY_PAGE_RESPONSE = new PageResponse();

    @SuppressWarnings("unchecked")
    public static <T> PageResponse<T> emptyPageResponse() {
        return EMPTY_PAGE_RESPONSE;
    }
}
