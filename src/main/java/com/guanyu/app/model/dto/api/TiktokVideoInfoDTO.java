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
@Setter
@ToString
public class TiktokVideoInfoDTO {

    /**
     * 视频标题
     */
    private String title;
    /**
     * 视频封面
     */
    private String cover;
    /**
     * 视频动态封面
     */
    private String coverDynamic;
    /**
     * 视频时长
     */
    private Long duration;
    /**
     * 视频时长格式化
     */
    private String durationFormat;
    /**
     * 视频宽度
     */
    private Integer width;
    /**
     * 视频高度
     */
    private Integer height;
    /**
     * 视频分辨率
     */
    private String accept;
    /**
     * 视频下载链接
     */
    private String url;

}
