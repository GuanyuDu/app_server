package com.guanyu.app.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.util.net.HttpRequest;
import com.guanyu.app.util.net.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 小程序杂七杂八功能的服务层
 *
 * @author Guanyu
 */
@Service
public class SubFunctionService {

    /**
     * 抖音分享链接转换成去水印下载链接
     *
     * @return List<String> 下载链接集合
     */
    public Result<List<String>> tikTokShareLinkTransform(String shareLink) {

        final String url = "http://iqiuz.xyz:9999/nwm";

        Map<String, String> params = new HashMap<>(16);
        params.put("text", shareLink);

        String result = HttpRequest.post(url, params, Collections.emptyMap()).dataOrNull();

        if (StringUtils.isNotEmpty(result)) {
            JSONObject obj = JSON.parseObject(result);

            if (obj != null && !obj.isEmpty()) {
                Integer code = obj.getInteger("code");
                if (code != null && code != 0) {
                    if (code == -1) {
                        return Result.fail(ErrorCode.SHARE_LINK_FORMAT_ERROR);
                    }
                    return Result.fail(code, obj.getString("msg"));
                }
                JSONArray data = obj.getJSONArray("data");

                if (data != null && !data.isEmpty()) {
                    return Result.ok(data.toJavaList(String.class));
                }
            }
        }
        return Result.fail(ErrorCode.DEPENDENT_SERVICE_ERROR);
    }
}
