package com.guanyu.app.util.net;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.util.log.Logs;
import okhttp3.*;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Http Request Client
 *
 * @author Guanyu
 */
public class HttpRequest {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS).build();

    /**
     * 创建并发送一个 Get 请求
     *
     * @param url       请求链接
     * @param headers   请求头 - 可选，可以填充空集合
     * @return          请求结果
     */
    public static HttpResponse<String> get(String url, Map<String, String> params, Map<String, String> headers) {
        // 参数校验
        Assert.notNull(url, "url can not be null");
        // 添加请求头
        Request.Builder builder = new Request.Builder();
        if (headers != null && !headers.isEmpty()) {
            for (String name : headers.keySet()) {
                builder.addHeader(name, headers.get(name));
            }
        }
        // 添加 URL 请求参数
        if (params != null && !params.isEmpty()) {
            url = url + "?" + Joiner.on("&").withKeyValueSeparator("=").join(params);
        }
        return call(builder.url(url).get().build());
    }

    /**
     * 创建并发送一个 Post 请求
     *
     * @param url       请求链接
     * @param params    请求参数 - 可选，可以填充空集合
     * @param headers   请求头 - 可选，可以填充空集合
     * @return          请求结果
     */
    public static HttpResponse<String> post(String url, Map<String, String> params, Map<String, String> headers) {
        // 参数校验
        Assert.notNull(url, "url can not be null");
        // 构建请求体
        FormBody.Builder form = new FormBody.Builder();
        for (String name : params.keySet()) {
            form.add(name, params.get(name));
        }
        // 添加请求头
        Request.Builder builder = new Request.Builder();
        for (String name : headers.keySet()) {
            builder.addHeader(name, headers.get(name));
        }
        return call(builder.url(url).post(form.build()).build());
    }

    /**
     * 发送部分公共代码提取
     *
     * @param request {@link Request} 构建的请求对象
     * @return HttpResponse 请求结果
     */
    private static HttpResponse<String> call(Request request) {
        try (Response response = CLIENT.newCall(request).execute()) {
            int code = response.code();
            String message = response.message();
            String body = Objects.requireNonNull(response.body()).string();
            Logs.detail.info("HttpRequest get response code = {}, message = {}, body = {}", code, message, body);

            if (response.isSuccessful()) {
                return HttpResponse.of(code, message, body);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return HttpResponse.fail(ErrorCode.HTTP_REQUEST_FAILED);
    }
}
