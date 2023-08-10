package com.guanyu.app.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.benmanes.caffeine.cache.Cache;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.constant.UserSexEnum;
import com.guanyu.app.model.dao.UserDao;
import com.guanyu.app.model.domain.UserDO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.UserService;
import com.guanyu.app.util.UserContext;
import com.guanyu.app.util.log.Logs;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

/**
 * 用户相关接口
 *
 * @author Guanyu
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.app-secret}")
    private String appSecret;

    @Resource
    private UserDao userDao;

    @Resource
    private Cache<String, UserContext.UserInfo> userCache;


    @Override
    public Result<String> login(String code) {

        OkHttpClient client = new OkHttpClient();

        HttpUrl url = HttpUrl.get("https://api.weixin.qq.com/sns/jscode2session").newBuilder()
                .addQueryParameter("appid", appid)
                .addQueryParameter("secret", appSecret)
                .addQueryParameter("js_code", code)
                .addQueryParameter("grant_type", "authorization_code")
                .build();
        Request request = new Request.Builder().url(url).build();

        String openid;
        String sessionKey;
        try (Response response = client.newCall(request).execute()) {
            String result = Objects.requireNonNull(response.body()).string();
            JSONObject res = JSON.parseObject(result);
            openid = res.getString("openid");
            sessionKey = res.getString("session_key");

        } catch (Exception e) {
            Logs.error.error("Request wechat server encounter a error.", e);
            return Result.fail(ErrorCode.DEPENDENT_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(openid) || StringUtils.isBlank(sessionKey)) {
            return Result.fail(ErrorCode.DEPENDENT_SERVICE_ERROR);
        }
        // 根据 openid 检查用户信息
        Optional<UserDO> optUser = userDao.getUserInfoByOpenid(openid);
        UserDO userDO;
        if (optUser.isPresent()) {
            userDO = optUser.get();
        } else {
            userDO = new UserDO(openid);
            userDO.setNickname("");
            userDO.setAvatar("");
            userDO.setSex(UserSexEnum.OTHER.getCode());
            userDao.saveOrUpdate(userDO);
        }
        // 生成用户登录 token
        String token = this.generateDigest(sessionKey, openid);
        // 将用户信息写入本地缓存
        userCache.put(token, new UserContext.UserInfo(userDO, sessionKey));

        return Result.ok(token);
    }

    @Override
    public Result<Void> updateBasicInfo(String nickname, String avatar) {

        // 更新数据库用户数据

        // 更新登录缓存数据

        return Result.ok();
    }

    /**
     * 根据用户信息生成 token
     *
     * @param sessionKey 微信登录凭证
     * @param openid     用户 openid
     * @return 用户登录凭证
     */
    private String generateDigest(String sessionKey, String openid) {
        try {
            // 待摘要字符串
            String paramStr = openid + sessionKey + appSecret + System.currentTimeMillis();
            // 生成 MD5 摘要信息
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            byte[] digest = MD5.digest(paramStr.getBytes(StandardCharsets.UTF_8));
            // 摘要信息转大写
            return Hex.encodeHexString(digest).toUpperCase();

        } catch (Exception e) {
            Logs.error.error("Generate digest encounter a error.", e);
        }
        return "";
    }

    public static void main(String[] args) {
        try {
            byte[] dePri = Base64.getDecoder().decode("");
            byte[] dePub = Base64.getDecoder().decode("");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(dePri));
            PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(dePub));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
