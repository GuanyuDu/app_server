package com.guanyu.app.model.dto.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 哔哩哔哩下载视频信息
 *
 * @author Guanyu
 */
@Getter
@ToString
public class BiliVideoInfoDTO {

    /**
     * 视频标题
     */
    private final String title;
    /**
     * 视频描述
     */
    private final String desc;
    /**
     * 视频封面
     */
    private final String cover;
    /**
     * 视频时长
     */
    private final List<BiliVideoItemDTO> list;

    public BiliVideoInfoDTO(String title, String desc, String cover, List<BiliVideoItemDTO> list) {
        this.title = title;
        this.desc = desc;
        this.cover = cover;
        this.list = list;
    }
}
