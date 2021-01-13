package com.guanyu.app.model.base;

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
     * total page number
     */
    private long pages;

    /**
     * total data number
     */
    private long totalCount;

    /**
     * current page data
     */
    private List<T> data;

    public PageInfo(IPage<T> page) {
        this.currentPage = page.getCurrent();
        this.totalCount = page.getTotal();
        this.pages = page.getPages();
        this.data = page.getRecords();
    }
}
