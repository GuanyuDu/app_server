package com.guanyu.app.model.dto;

import lombok.Data;

/**
 * @author Guanyu
 */
@Data
public class ConnectInfoDTO {

    private String host;

    private Integer port;

    private String username;

    private String password;

    private String springboard;
}
