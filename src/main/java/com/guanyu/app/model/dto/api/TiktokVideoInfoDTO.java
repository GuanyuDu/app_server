package com.guanyu.app.model.dto.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 抖音下载视频信息
 *
 * @author Guanyu
 */
@Getter
@ToString
public class TiktokVideoInfoDTO {

    /**
     * 视频标题
     */
    private final String title;
    /**
     * 视频封面
     */
    private final String cover;
    /**
     * 视频动态封面
     */
    private final String coverDynamic;
    /**
     * 视频时长
     */
    private final Long duration;
    /**
     * 视频时长格式化
     */
    private final String durationFormat;
    /**
     * 视频宽度
     */
    private final Integer width;
    /**
     * 视频高度
     */
    private final Integer height;
    /**
     * 视频分辨率
     */
    private final String accept;
    /**
     * 视频下载链接
     */
    private final String url;

    public TiktokVideoInfoDTO(String title, String cover, String coverDynamic, Long duration, String durationFormat, Integer width, Integer height, String accept, String url) {
        this.title = title;
        this.cover = cover;
        this.coverDynamic = coverDynamic;
        this.duration = duration;
        this.durationFormat = durationFormat;
        this.width = width;
        this.height = height;
        this.accept = accept;
        this.url = url;
    }
}
