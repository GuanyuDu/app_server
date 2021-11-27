package com.guanyu.app.service;

import com.guanyu.app.model.base.Result;

import java.util.List;

/**
 * 小程序杂七杂八功能的服务层
 *
 * @author Guanyu
 */
public class SubFunctionService {

    /**
     * 抖音分享链接转换成去水印下载链接
     *
     * @return List<String> 下载链接集合
     */
    public Result<List<String>> tikTokShareLinkTransform(String shareLink) {

        return Result.ok();
    }
}
