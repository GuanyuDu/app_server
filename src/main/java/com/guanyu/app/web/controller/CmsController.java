package com.guanyu.app.web.controller;

import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Guanyu
 */
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
}
