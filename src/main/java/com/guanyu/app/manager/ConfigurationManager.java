package com.guanyu.app.manager;

import com.guanyu.app.constant.MiniAppUIEnum;
import com.guanyu.app.model.dao.ConfigurationDao;
import com.guanyu.app.model.miniapp.ConfigurationDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 配置项公用代码逻辑
 *
 * @author Guanyu
 */
@Component
public class ConfigurationManager {

    @Resource
    private ConfigurationDao configurationDao;

    /**
     * 检查评论功能是否可用
     *
     * @return true 表示可用
     */
    public boolean commentable() {
        // 根据评论按钮枚举值获取最新配置
        Optional<ConfigurationDO> optConfig = configurationDao.getConfigByName(MiniAppUIEnum.COMMENT_BUTTON.getCode());
        return optConfig.map(configurationDO -> "1".equals(configurationDO.getValue())).orElse(false);
    }
}
