package com.guanyu.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户信息传输对象
 *
 * @author Guanyu
 */
@Data
@AllArgsConstructor
public class UserDTO {

    private String username;

    private String age;
}
