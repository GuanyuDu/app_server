package com.guanyu.app.model.dto.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Guanyu
 */
@Getter
@Setter
@ToString
public class VideoInfoDTO {

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频封面
     */
    private String cover;

    /**
     * 视频分片
     */
    private List<VideoItemDTO> list;


    public VideoInfoDTO(BiliVideoInfoDTO biliVideo) {
        this.title = biliVideo.getTitle();
        this.cover = biliVideo.getCover();
        this.list = new ArrayList<>(16);
        for (BiliVideoItemDTO item : biliVideo.getList()) {
            this.list.add(new VideoItemDTO(item));
        }
    }

    public VideoInfoDTO(TiktokVideoInfoDTO tiktokVideo) {
        this.title = tiktokVideo.getTitle();
        this.cover = tiktokVideo.getCover();
        this.list = Collections.singletonList(new VideoItemDTO(tiktokVideo));
    }
}
