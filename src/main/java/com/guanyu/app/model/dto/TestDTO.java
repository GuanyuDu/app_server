package com.guanyu.app.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author v.duguanyu
 */
@Getter
@Setter
@ToString
public class TestDTO {

    @JSONField(name = "CBID")
    private String CBID;

    private String name;

    private String cName;
}
