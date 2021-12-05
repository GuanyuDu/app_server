package com.guanyu.app.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guanyu.app.constant.FeiShuNotifyTypeEnum;
import com.guanyu.app.util.net.HttpRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 通知消息通用逻辑封装
 *
 * @author Guanyu
 */
@Component
public class NotificationManager {

    @Value("${feiShu.robot.secret}")
    private String robotSecret;

    private final String URL = "https://open.feishu.cn/open-apis/bot/v2/hook/";

    /**
     * 发送文字通知给飞书机器人
     *
     * @return  boolean 通知结果
     */
    public boolean feiShuTextNotification(String text) {

        Map<String, String> requestBody = new HashMap<>(16);
        requestBody.put("msg_type", FeiShuNotifyTypeEnum.TEXT.value);
        JSONObject content = new JSONObject();
        content.put(FeiShuNotifyTypeEnum.TEXT.value, text);
        requestBody.put("content", content.toJSONString());

        String data = HttpRequest.post(URL + robotSecret, requestBody, Collections.emptyMap()).dataOrNull();
        if (StringUtils.isNotEmpty(data)) {
            JSONObject dataObj = JSON.parseObject(data);
            return dataObj != null && dataObj.getInteger("StatusCode") == 0;
        }
        return false;
    }

    /**
     * 发送富文本通知给飞书机器人
     *
     * @param title 通知标题
     * @param text  通知内容
     * @param link  跳转链接
     * @return      通知结果
     */
    public boolean feiShuRichTextNotification(String title, String text, String showText, String link) {

        Map<String, String> requestBody = new HashMap<>(16);
        requestBody.put("msg_type", FeiShuNotifyTypeEnum.POST.value);
        JSONObject content = new JSONObject();
        JSONObject post = new JSONObject();
        JSONObject zhCn = new JSONObject();
        content.put(FeiShuNotifyTypeEnum.POST.value, post);
        // 设置标题
        zhCn.put("title", title);
        JSONArray contents = new JSONArray();
        JSONArray subContents = new JSONArray();
        // 设置正文
        JSONObject item = new JSONObject();
        item.put("tag", "text");
        item.put("text", text);
        subContents.add(item);
        // 设置超链接
        if (StringUtils.isNotEmpty(link)) {
            JSONObject linkObj = new JSONObject();
            linkObj.put("tag", "a");
            linkObj.put("text", showText);
            linkObj.put("href", link);
            subContents.add(linkObj);
        }
        contents.add(subContents);
        zhCn.put("content", contents);
        post.put("zh_cn", zhCn);
        requestBody.put("content", content.toJSONString());

        String data = HttpRequest.post(URL + robotSecret, requestBody, Collections.emptyMap()).dataOrNull();
        if (StringUtils.isNotEmpty(data)) {
            JSONObject dataObj = JSON.parseObject(data);
            System.out.println(dataObj);
            return dataObj != null && dataObj.getInteger("StatusCode") == 0;
        }
        return false;
    }
}
