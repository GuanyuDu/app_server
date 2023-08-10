package com.guanyu.app.service;

import com.guanyu.app.manager.NotificationManager;
import com.guanyu.app.model.dto.base.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 通知服务
 *
 * @author Guanyu
 */
@Service
public class NotificationService {

    @Resource
    private NotificationManager notificationManager;

    /**
     * 给飞书机器人发送通知
     *
     * @return  通知结果
     */
    public Result<Boolean> sendNotificationToFeiShuRobot() {

        return Result.ok();
    }
}
