package com.guanyu.app.service.impl;

import com.guanyu.app.mapper.ConnectInfoMapper;
import com.guanyu.app.model.dto.ConnectInfoDTO;
import com.guanyu.app.model.tool.ConnectInfoDO;
import com.guanyu.app.service.ConnectInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 连接信息查询
 * @author Guanyu
 */
@Service
public class ConnectInfoServiceImpl implements ConnectInfoService {

    private final Logger logger = LoggerFactory.getLogger(ConnectInfoServiceImpl.class);

    ConnectInfoMapper connectInfoMapper;

    @Autowired
    public ConnectInfoServiceImpl(ConnectInfoMapper connectInfoMapper) {
        this.connectInfoMapper = connectInfoMapper;
    }

    @Override
    public List<String> getInstanceNameByTypeAndEnv(Integer type, String env) {

        boolean isNull = type == null || type < 1 || StringUtils.isBlank(env);
        boolean condition = !Arrays.asList("dev", "uat", "pro").contains(env);

        if (isNull || condition) {
            logger.info("ConnectInfoServiceImpl -> getInstanceNameByTypeAndEnv | parameters error | type: {}, env: {}", type, env);
            return null;
        }

        return connectInfoMapper.getDatabaseByTypeAndEnv(type, env);
    }

    @Override
    public List<ConnectInfoDTO> getConnectInfos(Integer type, String env, String dbName) {

        boolean condition = !Arrays.asList("dev", "uat", "pro").contains(env);

        if (type == null || type < 1 || StringUtils.isBlank(env) || StringUtils.isBlank(dbName) || condition) {
            logger.info("ConnectInfoServiceImpl -> getInstanceNameByTypeAndEnv | parameters error | " +
                    "type: {}, env: {}, database: {}", type, env, dbName);
            return null;
        }
        List<ConnectInfoDO> connectInfoDOS = connectInfoMapper.getConnectInfos(type, env, dbName);
        List<ConnectInfoDTO> connectInfoDTOList = new ArrayList<>();

        connectInfoDOS.forEach(connectInfoDO -> {
            ConnectInfoDTO connectInfoDto = new ConnectInfoDTO();
            connectInfoDto.setHost(connectInfoDO.getHost());
            connectInfoDto.setPort(connectInfoDO.getPort());
            connectInfoDto.setUsername(connectInfoDO.getUsername());
            connectInfoDto.setPassword(connectInfoDO.getPassword());
            // set springboard machine
            if (connectInfoDO.getType() == 1) {
                ConnectInfoDO springboardMachine = connectInfoMapper.selectById(connectInfoDO.getSpringboardId());
                if (springboardMachine != null) {
                    connectInfoDto.setSpringboard(springboardMachine.getHost() + "-" + springboardMachine.getPassword());
                }
            }
            connectInfoDTOList.add(connectInfoDto);
        });

        return connectInfoDTOList;
    }
}
