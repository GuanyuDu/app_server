package com.guanyu.app.model.dto.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Guanyu
 */
@Getter
@Setter
@ToString
public class VideoItemDTO {

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
     * 视频分片下载链接
     */
    private String url;


    public VideoItemDTO(BiliVideoItemDTO biliVideo) {
        this.title = biliVideo.getTitle();
        this.duration = biliVideo.getDuration();
        this.durationFormat = biliVideo.getDurationFormat();
        this.width = biliVideo.getWidth();
        this.height = biliVideo.getHeight();
        this.url = biliVideo.getUrl();
    }

    public VideoItemDTO(TiktokVideoInfoDTO tiktokVideo) {
        this.title = tiktokVideo.getTitle();
        this.duration = tiktokVideo.getDuration();
        this.durationFormat = tiktokVideo.getDurationFormat();
        this.width = tiktokVideo.getWidth();
        this.height = tiktokVideo.getHeight();
        this.url = tiktokVideo.getUrl();
    }
}
