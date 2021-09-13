package com.guanyu.app.model.miniapp.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author v.duguanyu
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class TestDTO {

    @JSONField(name = "CBID")
    private String cbId;

    private String name;

    private String cName;
}
