package com.guanyu.app.service.impl;

import com.guanyu.app.mapper.ConnectInfoMapper;
import com.guanyu.app.model.dto.ConnectInfoDto;
import com.guanyu.app.model.tool.ConnectInfo;
import com.guanyu.app.service.ConnectInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if (type == null || StringUtils.isBlank(env)) {
            logger.info("ConnectInfoServiceImpl -> getInstanceNameByTypeAndEnv | parameters error | type: {}, env: {}", type, env);
            return null;
        }

        return connectInfoMapper.getDatabaseByTypeAndEnv(type, env);
    }

    @Override
    public List<ConnectInfoDto> getConnectInfos(Integer type, String env, String dbName) {

        if (type == null || StringUtils.isBlank(env) || StringUtils.isBlank(dbName)) {
            logger.info("ConnectInfoServiceImpl -> getInstanceNameByTypeAndEnv | parameters error | " +
                    "type: {}, env: {}, database: {}", type, env, dbName);
            return null;
        }
        List<ConnectInfo> connectInfos = connectInfoMapper.getConnectInfos(type, env, dbName);
        List<ConnectInfoDto> connectInfoDtoList = new ArrayList<>();

        connectInfos.forEach(connectInfo -> {
            ConnectInfoDto connectInfoDto = new ConnectInfoDto();
            connectInfoDto.setHost(connectInfo.getHost());
            connectInfoDto.setPort(connectInfo.getPort());
            connectInfoDto.setUsername(connectInfo.getUsername());
            connectInfoDto.setPassword(connectInfo.getPassword());
            // set springboard machine
//            if (connectInfo.getType() == 1) {
//                ConnectInfo springboardMachine = connectInfoMapper.selectById(connectInfo.getSpringboardId());
//                if (springboardMachine != null) {
//                    connectInfoDto.setSpringboard(springboardMachine.getHost() + "-" + springboardMachine.getPassword());
//                }
//            }
            connectInfoDtoList.add(connectInfoDto);
        });

        return connectInfoDtoList;
    }
}
