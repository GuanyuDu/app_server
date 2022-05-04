package com.guanyu.app.model.dto.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 哔哩哔哩下载视频分片
 *
 * @author Guanyu
 */
@Getter
@ToString
public class BiliVideoItemDTO {

    /**
     * 视频分片标题
     */
    private final String title;
    /**
     * 视频分片时长
     */
    private final Long duration;
    /**
     * 视频分片时长格式化
     */
    private final String durationFormat;
    /**
     * 视频分片宽度
     */
    private final Integer width;
    /**
     * 视频分片高度
     */
    private final Integer height;
    /**
     * 视频分片分辨率
     */
    private final List<String> accept;
    /**
     * 视频分片下载链接
     */
    private final String url;

    public BiliVideoItemDTO(String title, Long duration, String durationFormat, Integer width, Integer height, List<String> accept, String url) {
        this.title = title;
        this.duration = duration;
        this.durationFormat = durationFormat;
        this.width = width;
        this.height = height;
        this.accept = accept;
        this.url = url;
    }
}
