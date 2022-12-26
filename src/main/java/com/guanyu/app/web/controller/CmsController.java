package com.guanyu.app.web.controller;

import com.alibaba.excel.EasyExcel;
import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.UserDTO;
import com.guanyu.app.model.dto.base.Result;
import com.guanyu.app.model.miniapp.UserDO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guanyu
 */
@Tag(name = "资源管理")
@RestController
@RequestMapping("/cms")
public class CmsController {

    @PostMapping("/file")
    public Result<String> upload(@RequestParam("upload_files") List<MultipartFile> uploadFiles) {
        if (uploadFiles == null || uploadFiles.isEmpty()) {
            return Result.fail(ErrorCode.UNKNOWN_ERROR);
        }
        for (MultipartFile file : uploadFiles) {

            String originalName = file.getOriginalFilename();
            File localFile = new File("F:\\Temp\\" + (StringUtils.isNotEmpty(originalName) ? originalName : "temp_file_name"));
            try (
                InputStream inputStream = file.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(localFile)
            ) {
                if (!localFile.exists()) {
                    boolean isCreated = localFile.createNewFile();
                    if (!isCreated) {
                        System.out.println("File create failed.");
                    }
                }
                // write file to disc
                byte[] data = new byte[1024];
                while (inputStream.read(data) != -1) {
                    outputStream.write(data);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.ok();
    }

    @GetMapping("/download")
    public Result<Void> download(HttpServletResponse response) throws IOException {

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=test.xlsx");
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("jack", "24"));
        list.add(new UserDTO("rose", "22"));

        EasyExcel.write(response.getOutputStream(), UserDTO.class).sheet("模板").doWrite(list);

        return Result.ok();
    }
}
