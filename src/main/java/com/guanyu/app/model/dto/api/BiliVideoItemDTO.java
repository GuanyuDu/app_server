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
@Setter
@ToString
public class BiliVideoItemDTO {

    /**
     * 视频分片标题
     */
    private String title;
    /**
     * 视频分片时长
     */
    private Long duration;
    /**
     * 视频分片时长格式化
     */
    private String durationFormat;
    /**
     * 视频分片宽度
     */
    private Integer width;
    /**
     * 视频分片高度
     */
    private Integer height;
    /**
     * 视频分片分辨率
     */
    private List<String> accept;
    /**
     * 视频分片下载链接
     */
    private String url;
}
