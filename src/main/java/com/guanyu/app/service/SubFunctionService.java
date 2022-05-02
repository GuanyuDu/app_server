package com.guanyu.app.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.api.BiliVideoInfoDTO;
import com.guanyu.app.model.dto.api.BiliVideoItemDTO;
import com.guanyu.app.model.dto.api.TiktokVideoInfoDTO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.util.log.Logs;
import com.guanyu.app.util.net.HttpRequest;
import com.guanyu.app.util.net.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 小程序杂七杂八功能的服务层
 *
 * @author Guanyu
 */
@Service
public class SubFunctionService {

    /**
     * 分享链接转换基础链接地址
     */
    @Value("#{${third-part.domain} + '/api/%s/video'}")
    private String baseUrl;

    @Value("${third-part.app-id}")
    private String appId;

    @Value("${third-part.app-secret}")
    private String appSecret;

    /**
     * 分享链接转换成去水印下载链接
     * 目前仅支持抖音、哔哩哔哩分享连接转换
     *
     * @param shareLink 分享链接
     * @return {@link List} 下载链接集合
     */
    public Result<List<String>> shareLinkTransform(String shareLink) {
        // 判断当前分享链接是抖音还是哔哩哔哩，构建请求链接
        boolean isTiktok = shareLink.contains("douyin");
        String url = String.format(baseUrl, isTiktok ? "douyin" : "bilibili");
        Map<String, String> params = new HashMap<>(16);
        params.put("app_id", appId);
        params.put("app_secret", appSecret);
        params.put("url", Base64.getEncoder().encodeToString(shareLink.getBytes(StandardCharsets.UTF_8)));
        // 发送 HTTP 请求，调用接口
        String response = HttpRequest.get(url, Maps.newHashMap(), params).dataOrNull();

        if (StringUtils.isNotEmpty(response)) {
            try {
                JSONObject res = JSON.parseObject(response);
                if (res != null && !res.isEmpty()) {
                    int code = res.getIntValue("code");
                    String msg = res.getString("msg");
                    Logs.detail.info("Request api code = {}, msg = {}", code, msg);
                    // code 为 1 表示依赖服务请求成功
                    if (code == 1) {
                        String data = res.getString("data");
                        if (isTiktok) {
                            TiktokVideoInfoDTO videoInfo = JSON.parseObject(data, TiktokVideoInfoDTO.class);
                            return Result.ok(Collections.singletonList(videoInfo.getUrl()));
                        }
                        BiliVideoInfoDTO videoInfo = JSON.parseObject(data, BiliVideoInfoDTO.class);
                        return Result.ok(videoInfo.getList().parallelStream()
                                .map(BiliVideoItemDTO::getUrl).collect(Collectors.toList()));
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return Result.fail(ErrorCode.DEPENDENT_SERVICE_ERROR);
    }
}
