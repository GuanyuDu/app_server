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
@Setter
@ToString
public class BiliVideoInfoDTO {

    /**
     * 视频标题
     */
    private String title;
    /**
     * 视频描述
     */
    private String desc;
    /**
     * 视频封面
     */
    private String cover;
    /**
     * 视频时长
     */
    private List<BiliVideoItemDTO> list;

}
