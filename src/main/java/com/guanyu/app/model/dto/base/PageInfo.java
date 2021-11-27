package com.guanyu.app.model.dto.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Guanyu
 */
@Getter
@Setter
public class PageInfo<T> {

    /**
     * current page
     */
    private long currentPage;

    /**
     * total data number
     */
    private long totalCount;

    /**
     * current page data
     */
    private List<T> data;


    public static <T> PageInfo<T> of(long currentPage, long totalCount, List<T> data) {
        return new PageInfo<>(currentPage, totalCount, data);
    }

    public PageInfo(long currentPage, long totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.data = data;
    }

    public PageInfo(IPage<T> page) {
        this.currentPage = page.getCurrent();
        this.totalCount = page.getTotal();
        this.data = page.getRecords();
    }
}
