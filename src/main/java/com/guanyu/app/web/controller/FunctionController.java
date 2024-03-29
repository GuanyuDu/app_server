package com.guanyu.app.web.controller;

import com.guanyu.app.model.dto.api.VideoInfoDTO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.service.SubFunctionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小程序功能接口
 *
 * @author Guanyu
 */
@Tag(name = "功能相关接口", description = "功能列中使用到的所有接口")
@RestController
@RequestMapping("/function")
public class FunctionController {

    @Resource
    private SubFunctionService subFunctionService;


    @GetMapping("/eating_today")
    public Result<String> whatAreWeEatingToday() {
        return Result.ok("Sorry, no ideas!");
    }

    @GetMapping("/link_transform")
    public Result<VideoInfoDTO> shareLinkTransform(@RequestParam("share_link") String shareLink) {
        return subFunctionService.shareLinkTransform(shareLink);
    }
}
