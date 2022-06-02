package com.guanyu.app.model.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

/**
 * 用户信息传输对象
 *
 * @author Guanyu
 */
@Data
@AllArgsConstructor
public class UserDTO {

    @ExcelProperty("User_Name")
    private String username;

    @ExcelProperty("Age")
    private String age;
}
