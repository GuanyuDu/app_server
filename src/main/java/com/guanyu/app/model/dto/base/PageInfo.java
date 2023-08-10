package com.guanyu.app.model.dto.base;

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
    private long current;

    /**
     * total data number
     */
    private long total;

    /**
     * current page data
     */
    private List<T> data;

    public static <T> PageInfo<T> of(long current, long total, List<T> data) {
        return new PageInfo<>(current, total, data);
    }

    public PageInfo(long current, long total, List<T> data) {
        this.current = current;
        this.total = total;
        this.data = data;
    }

}
